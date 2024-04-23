import {Component, OnInit} from '@angular/core';
import {MatCard, MatCardContent} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {ProductListComponent} from "../../components/product-list/product-list.component";
import {Observable, tap} from "rxjs";
import {ProductPage} from "../../models/ProductPage";
import {ProductService} from "../../services/product/product.service";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {AsyncPipe} from "@angular/common";
import {MatProgressSpinner} from "@angular/material/progress-spinner";
import {Product} from "../../models/Product";

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [
    MatCardContent,
    MatToolbar,
    ProductListComponent,
    MatCard,
    AsyncPipe,
    MatProgressSpinner,
    MatPaginator
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss'
})
export class ProductsComponent implements OnInit {

  products$: Observable<ProductPage> | null = null;

  pageIndex: number = 0;
  pageSize: number = 5;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.refresh()
  }

  refresh(pageEvent: PageEvent = {length: 0, pageIndex: 0, pageSize: 5}) {
    this.products$ = this.productService
      .list(pageEvent.pageIndex, pageEvent.pageSize)
      .pipe(
        tap(() => {
          this.pageIndex = pageEvent.pageIndex;
          this.pageSize = pageEvent.pageSize;
        })
      );
  }

  addProduct() {

  }

  editProduct(product: Product) {
  }

  removeProduct(product: Product) {

  }
  detailProduct(product: Product) {

  }

}
