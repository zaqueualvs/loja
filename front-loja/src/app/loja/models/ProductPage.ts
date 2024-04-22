import {Product} from './Product';

export interface ProductPage{
  products: Product[];
  totalElements: number;
  totalPages?: number;
}
