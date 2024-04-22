import { Component } from '@angular/core';
import {MatCard, MatCardContent} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {ProductListComponent} from "../../components/product-list/product-list.component";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [
    MatCardContent,
    MatToolbar,
    ProductListComponent,
    MatCard
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss'
})
export class ProductsComponent {

}
