import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Brand } from '../models/brand';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private http:HttpClient) { }

  getAllBrands(){
    return this.http.get<Brand[]>('http://localhost:8080/api/v1/brands');
  }

  getProductsByBrandId(id:number){
    return this.http.get<Product[]>('http://localhost:8080/api/v1/brands/'+id);
  }

  getBrandsCount(){
    return this.http.get<number>('http://localhost:8080/api/v1/admin/brands/count');
  }
}
