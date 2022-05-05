import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  getProductCount(){
    return this.http.get<number>('http://localhost:8080/api/v1/products/count');
  }

  getAllProducts(){
    return this.http.get<Product[]>('http://localhost:8080/api/v1/products');
  }

  getProductById(id:number){
    return this.http.get<Product>('http://localhost:8080/api/v1/products/'+id);
  }

  getProductsByGender(gender:String){
    return this.http.get<Product[]>('http://localhost:8080/api/v1/products/gender/'+gender);
  }

  searchProducts(query:String){
    return this.http.get<Product[]>('http://localhost:8080/api/v1/products/search?q='+query);
  }

  getProductsByPage(pgnum:number,size:number){
    return this.http.get<Product[]>('http://localhost:8080/api/v1/page/products?pgnum='+pgnum+'&size='+size);
  }

  postProduct(product: Product){
    return this.http.post<Product>('http://localhost:8080/api/v1/products',product);
   
  }

  getProductsCount(){
    return this.http.get<number>('http://localhost:8080/api/v1/products/count');
  }
}
