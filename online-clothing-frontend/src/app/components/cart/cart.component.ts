import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Order } from 'src/app/models/order';
import { Orderline } from 'src/app/models/orderline';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  items:Orderline[] = [];
  
  total:number = 0;
  subtotal:number;
  discount:number;
  order:Order=<Order>{};

  user:User;//get user
  islogin:boolean;
  userid:number = 0;

  constructor(private cartService: CartService, 
   private  orderService: OrderService, private router:Router,
   private authService:AuthService) { }

  ngOnInit(): void {
    this.cartService.cartItems.subscribe(data=>{
      this.items = data;

      if(this.items) 
        this.order.totalPayment = this.getTotal(this.items);
    });

    this.islogin = localStorage.getItem("status") ? true : false;
      if(this.islogin){
        if(this.authService.getCurrentUser() != null){
          this.user = JSON.parse(this.authService.getCurrentUser()!);
          let role = this.user.role;       
        if(role === "user"){
          this.userid = this.user.userid;
        } 
        }
      }
  }

  onDelete(i:number){
    this.items.splice(i,1);
    this.cartService.setCartData(this.items);
    if(this.items){
      this.order.totalPayment = this.getTotal(this.items);
    }
  }

  validateInput(event:any, i:number){
    const q = parseInt(event.target.value);
    if(q<1){
      event.target.value = this.items[i].quantity;
      return;
    }
    this.QuantityUpdated(q,i);
  }

  private QuantityUpdated(q:number, i:number){
    this.items[i].quantity = q;
    this.cartService.setCartData(this.items);
    this.order.totalPayment = this.getTotal(this.items);
  }

  emptyCart(){
    this.items = [];
    this.cartService.setCartData(this.items);
  }

  onCheckout(){
    //*** get user id  */
    this.order.userid = this.userid;
    this.order.orderlines = this.items;

    //==> using localstorage send data
    this.orderService.captureOrder(this.order);
    this.router.navigate(["delivery-address"]);
    
   //==> using history state send data
  //  let navigationExtras : NavigationExtras = {
  //    state : {
  //      orderPlaced: this.order
  //    }
  //  }
  //   this.router.navigate(["delivery-address"],navigationExtras);
  }

  getTotal(data:Orderline[]){
    let subs = 0;
    for(const item of data){
      subs += item.price * item.quantity;
    }
    this.subtotal = subs;
    return this.subtotal;
  }

}


