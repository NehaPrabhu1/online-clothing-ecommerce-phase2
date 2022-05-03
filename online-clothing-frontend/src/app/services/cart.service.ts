import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Orderline } from '../models/orderline';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  placeholder:any = [];
  cartItems = new BehaviorSubject([]);
  constructor() {
    const ls = this.getCartData();
    if(ls) this.cartItems.next(ls);
   }

   setCartData(data:any){
    localStorage.setItem('cart',JSON.stringify(data));
    this.cartItems.next(this.getCartData());
  }

  getCartData(){
    return JSON.parse(localStorage.getItem("cart")!);
  }

  addItem(product:Orderline){
    const ls = this.getCartData();

    let exist:Orderline | undefined= undefined;
    if(ls){
      exist = ls.find((item: Orderline)=>{
        return item.productid === product.productid && item.size === product.size;
      });

    }
    if(exist){
      exist.quantity++;
      this.setCartData(ls);
    }
    else{
      if(ls){
        const newData = [...ls, product];
        this.setCartData(newData);
      }
     
        this.placeholder.push(product);
        this.setCartData(this.placeholder);
    }  
}

}
