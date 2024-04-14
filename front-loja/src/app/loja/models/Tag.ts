import {Product} from './Product';

export interface Tag {
  id: string;
  name: string;
  products?: Product[]
}
