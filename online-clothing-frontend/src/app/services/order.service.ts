import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order';
import { Orderline } from '../models/orderline';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  orderToBePlaced:Order=<Order>{};

  constructor(private http:HttpClient) { }

  getAllOrdersOfUser(id:number){
    return this.http.get<Order[]>('http://localhost:8080/api/v1/user/orders/userid/'+id);
  }

  captureOrder(order:Order){
    localStorage.setItem('order',JSON.stringify(order));
    console.log(order);
  }

  getOrderCaptured(){
    this.orderToBePlaced = JSON.parse(localStorage.getItem('order')!);
    return this.orderToBePlaced;
  }

  postOrder(order:Order){
    return this.http.post('http://localhost:8080/api/v1/user/orders',order);
  }

  getOrdersCount(){
    return this.http.get<number>('http://localhost:8080/api/v1/admin/orders/count');
  }

  getOrderlineCount(){
    return this.http.get<number>('http://localhost:8080/api/v1/admin/orderlines/count');
  }
}
