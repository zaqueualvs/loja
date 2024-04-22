import {Tag} from './Tag';

export interface Product{
  id: string;
  name: string;
  description: string;
  targetMarket: string;
  tags?: Tag[];
}
