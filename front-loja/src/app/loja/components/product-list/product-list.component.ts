import {Component, Input, Output} from '@angular/core';
import {Product} from "../../models/Product";
import EventEmitter from "node:events";
import {
  MatCell,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderRow,
  MatRow,
  MatTable,
  MatTableModule
} from "@angular/material/table";
import {MatCard} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [
    MatTableModule,
    MatHeaderRow,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatRow,
    MatCard,
    MatToolbar,
    FormsModule
  ],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.scss'
})
export class ProductListComponent {


  @Input() products: Product[] = [];
  @Output() addProduct:EventEmitter<boolean> = new EventEmitter(false);
  @Output() detailProduct:EventEmitter<Product> = new EventEmitter(false);
  @Output() editProduct: EventEmitter<Product> = new EventEmitter(false);
  @Output() removeProduct: EventEmitter<Product> = new EventEmitter(false);

  readonly displayedColumns: string[] = ['id', 'name', 'description'];

  onAddProduct() {
    this.addProduct.emit(true);
  }

  onEditProduct(product: Product) {
    this.editProduct.emit(product);
  }

  onRemoveProduct(product: Product) {
    this.removeProduct.emit(product);
  }

  onDetailProduct(product: Product) {
    this.detailProduct.emit(product);
  }
}
