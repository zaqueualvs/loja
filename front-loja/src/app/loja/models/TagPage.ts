import {Tag} from './Tag';

export interface TagPage{
  tags: Tag[];
  totalElements: number;
  totalPages?: number;
}
