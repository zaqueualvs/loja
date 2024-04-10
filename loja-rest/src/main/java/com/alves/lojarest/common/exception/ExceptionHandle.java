package com.alves.lojarest.common.exception;

import com.alves.lojarest.application.domain.exceptions.EntityInUseException;
import com.alves.lojarest.application.domain.exceptions.EntityNotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {
    public static final String GENERIC_ERROR_MESSAGE_END_USER
            = "An unexpected internal system error has occurred. Please try again and see if "
            + "the problem persists, contact your system administrator.";
    private final MessageSource messageSource;

    public ExceptionHandle(@Qualifier("messageSource") MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnknown(Exception ex,
                                                WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ProblemType problemType = ProblemType.SYSTEM_ERROR;
        String detail = GENERIC_ERROR_MESSAGE_END_USER;

        log.error(ex.getMessage(), ex);

        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
                                                        HttpStatusCode status, WebRequest request) {

        if (ex instanceof MethodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatchException(
                    (MethodArgumentTypeMismatchException) ex, headers, status, request);
        }

        return super.handleTypeMismatch(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
                                                                             HttpHeaders headers,
                                                                             HttpStatusCode status,
                                                                             WebRequest request) {
        ProblemType problemType = ProblemType.INVALID_PARAMETER;

        String detail = String.format("The URL parameter '%s' has been assigned the value '%s',"
                        + "which is of an invalid type. Correct and enter a value compatible with type %s.",
                ex.getName(), ex.getValue(), Objects.requireNonNull(ex.getRequiredType()).getSimpleName());

        Problem problem = createProblemBuilder(HttpStatus.valueOf(status.value()), problemType, detail)
                .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Throwable rootCause = ExceptionUtils.getRootCause(ex);
        if (rootCause instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, status, request);
        } else if (rootCause instanceof PropertyBindingException) {
            return handlerPropertyBindingException((PropertyBindingException) rootCause, headers, status, request);
        }

        ProblemType problemType = ProblemType.INCOMPREHENSIBLE_MESSAGE;
        String detail = "The request body is invalid, Check syntax error";
        Problem problem = createProblemBuilder(HttpStatus.valueOf(status.value()), problemType, detail)
                .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }


    public ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex,
                                                               HttpHeaders headers,
                                                               HttpStatusCode status,
                                                               WebRequest request) {
        String path = ex.getPath().stream()
                .map(JsonMappingException.Reference::getFieldName)
                .collect(Collectors.joining("."));
        ProblemType problemType = ProblemType.INCOMPREHENSIBLE_MESSAGE;
        String detail = String.format("Property %s has been assigned the value %s,"
                        + "which is of an invalid type. Correct and enter a value compatible with type %s.",
                path, ex.getValue(), ex.getTargetType().getSimpleName());
        Problem problem = createProblemBuilder(HttpStatus.valueOf(status.value()), problemType, detail)
                .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
                .build();
        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    public ResponseEntity<Object> handlerPropertyBindingException(PropertyBindingException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        String path = ex.getPath().stream()
                .map(JsonMappingException.Reference::getFieldName)
                .collect(Collectors.joining("."));
        ProblemType problemType = ProblemType.INVALID_PARAMETER;
        String detail = String.format("Property %s does not exist."
                + "Correct or remove this property and try again.", path);
        Problem problem = createProblemBuilder(HttpStatus.valueOf(status.value()), problemType, detail)
                .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
                .build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
        String detail = String.format("The resource %s, that you tried to access, it is non-existent.",
                ex.getRequestURL());
        Problem problem = createProblemBuilder(HttpStatus.valueOf(status.value()), problemType, detail)
                .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(EntityInUseException.class)
    public ResponseEntity<Object> handleEntityInUseException(EntityInUseException ex,
                                                        WebRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ProblemType problemType = ProblemType.ENTITY_IN_USE;
        String detail = ex.getMessage();
        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex,
                                                           WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
        String detail = ex.getMessage();
        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex,
                                                                    HttpHeaders headers,
                                                                    HttpStatusCode status,
                                                                    WebRequest request) {
        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
        String detail = String.format("The resource %s, that you tried to access, it is non-existent.",
                ex.getResourcePath());
        Problem problem = createProblemBuilder(HttpStatus.valueOf(status.value()), problemType, detail)
                .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        return handleValidationInternal(ex,
                ex.getBindingResult(),
                headers,
                status,
                request);
    }

    private ResponseEntity<Object> handleValidationInternal(Exception ex,
                                                            BindingResult bindingResult,
                                                            HttpHeaders headers,
                                                            HttpStatusCode status,
                                                            WebRequest request) {
        ProblemType problemType = ProblemType.INVALID_DATA;
        String detail = "One or more fields are invalid. Please fill in " +
                "correct and try again";

        List<Problem.Object> problemObjects = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> {
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
                    String name = objectError.getObjectName();
                    if (objectError instanceof FieldError) {
                        name = ((FieldError) objectError).getField();
                    }
                    return Problem.Object.builder()
                            .name(name)
                            .userMessage(message)
                            .build();
                })
                .collect(Collectors.toList());


        Problem problem = createProblemBuilder(HttpStatus.valueOf(status.value()), problemType, detail)
                .userMessage(detail)
                .objects(problemObjects)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

        if (body == null) {
            body = Problem.builder()
                    .title(HttpStatus.valueOf(statusCode.value()).getReasonPhrase())
                    .status(statusCode.value())
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .title((String) body)
                    .status(statusCode.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status,
                                                        ProblemType problemType,
                                                        String detail) {
        return Problem.builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail)
                .timestamp(OffsetDateTime.now());
    }
}
