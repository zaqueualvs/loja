import {Injectable} from '@angular/core';
import {Product} from "../../models/Product";
import {HttpClient} from "@angular/common/http";
import {ProductPage} from "../../models/ProductPage";
import {first, of, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API = 'api/products';
  private cache: Product[] = [];

  constructor(private http: HttpClient) {

  }

  list(page = 0, pageSize = 5) {
    return this.http.get<ProductPage>(this.API, {params: {page, pageSize}})
      .pipe(
        first(),
        tap(data => (this.cache = data.products))
      );
  }

  loadById(id: string) {
    if (this.cache.length > 0) {
      const product = this.cache.find(product => product.id === id);
      return product != null ? of(product) : this.getById(id);
    }
    return this.getById(id);
  }

  private getById(id: string) {
    return this.http.get<Product>(`${this.API}/id/${id}`)
      .pipe(first());
  }

  save(product: Product) {
    if (product.id) {
      return this.update(product);
    }
    return this.create(product);
  }

  private update(product: Product) {
    return this.http.put(`${this.API}/${product.id}`, product)
      .pipe(first());
  }
  private create(product: Product) {
    return this.http.put(`${this.API}`, product)
      .pipe(first());
  }
  remove(id: string) {
    return this.http.delete<Product>(`${this.API}/${id}`)
      .pipe(first())
  }
}
