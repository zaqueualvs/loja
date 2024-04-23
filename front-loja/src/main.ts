import {bootstrapApplication, BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app/app.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {provideAnimations} from "@angular/platform-browser/animations";
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {PreloadAllModules, provideRouter, withPreloading} from "@angular/router";
import {routes} from "./app/app.routes";
import {importProvidersFrom} from "@angular/core";

bootstrapApplication(AppComponent,
  {
    providers: [importProvidersFrom(BrowserModule, MatToolbarModule),
      provideAnimations(),
      provideHttpClient(withInterceptorsFromDi()),
      provideRouter(routes, withPreloading(PreloadAllModules))]
  })
  .catch((err) => console.error(err));
