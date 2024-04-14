import {Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {ProductsComponent} from "./loja/products/products.component";

export const routes: Routes = [
  {path: '', pathMatch: "full", redirectTo: 'loja'},
  {
    path: 'loja',
    loadChildren: () => import('./loja/loja.routes')
      .then(loja => loja.LOJA_ROUTES)
  }
];
