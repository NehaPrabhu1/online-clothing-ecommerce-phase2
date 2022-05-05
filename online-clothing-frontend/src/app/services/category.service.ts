import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../models/category';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  getAllCategories(){
    return this.http.get<Category[]>('http://localhost:8080/api/v1/categories');
  }

  getCategoriesCount(){
    return this.http.get<number>('http://localhost:8080/api/v1/admin/categories/count');
  }

  getProductsByCategoryId(id:number){
    return this.http.get<Product[]>('http://localhost:8080/api/v1/categories/'+id);
  }

  
}
