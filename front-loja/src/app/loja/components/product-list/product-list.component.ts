import {Component, Input, Output} from '@angular/core';
import {Product} from "../../models/Product";
import EventEmitter from "node:events";

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.scss'
})
export class ProductListComponent {


  @Input products: Product[] = [];
  @Output addProduct: EventEmitter<Product> = new EventEmitter(false);
  @Output detailProduct: EventEmitter<Product> = new EventEmitter(false);
  @Output editProduct: EventEmitter<Product> = new EventEmitter(false);
  @Output removeProduct: EventEmitter<Product> = new EventEmitter(false);


  onAddProduct() {
    this.addProduct.emit(false);
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
