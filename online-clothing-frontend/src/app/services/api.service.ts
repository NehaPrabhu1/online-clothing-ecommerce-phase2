import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Discount } from '../models/discount';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  public postDiscount(discount:Discount ){
     return this.http.post("http://localhost:8080/api/v1/admin/discount",discount);
   }
  
  public getDiscount(){ 
    return this.http.get<Discount[]>("http://localhost:8080/api/v1/admin/discount");
  }
}
