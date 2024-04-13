INSERT INTO product(name, description, target_market)
VALUES ('Smartphone', 'Computador de bolso que pode ser levado para qualquer lugar', 'Qualquer pessoa'),
       ('Sapato', 'Calçado para ser usado no pe', 'Qualquer pessoa'),
       ('Calça', 'Tipo de rouba vai ate metade do joelho', 'Qualquer pessoa'),
       ('Fone de ouvido', 'Acessorio para usar no ouvido para ouvir musica', 'Qualquer pessoa'),
       ('Carregador', 'Acessorio para carregar o Smartphone', 'Qualquer pessoa'),
       ('Sandalia', 'Calçado para ser usado na praia ou dentro de casa', 'Qualquer pessoa'),
       ('Servidor', 'Servidor para armazenar uma rede local', 'Empresas');

INSERT INTO tag(name)
VALUES ('Tecnologia'),
       ('Couro'),
       ('Plastico'),
       ('Offline'),
       ('Energia'),
       ('Pano'),
       ('Wifi');

INSERT INTO product_tag(product_id, tag_id)
VALUES (1, 1),
       (1, 3),
       (1, 4),
       (2, 2),
       (3, 6),
       (4, 1),
       (4, 4),
       (4, 3),
       (5, 5);