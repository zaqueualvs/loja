import {Product} from './Product';

export interface Tag{
  products: Product[];
  totalElements: number;
  totalPages?: number;
}
