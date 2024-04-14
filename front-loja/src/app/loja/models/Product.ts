import {Tag} from './Tag';

export interface Tag{
  id: string;
  name: string;
  description: string;
  targetMarket: string;
  tags?: Tag[];
}
