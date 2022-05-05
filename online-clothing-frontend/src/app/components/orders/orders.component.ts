import { Component, OnInit } from '@angular/core';
import { DeliveryAddess } from 'src/app/models/deliveryaddress';
import { Order } from 'src/app/models/order';
import { Orderline } from 'src/app/models/orderline';
import { Product } from 'src/app/models/product';
import { Review } from 'src/app/models/review';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { OrderService } from 'src/app/services/order.service';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders:Order[];
  orderlines:Orderline[][] = [];
  deliveryAddress:DeliveryAddess[] =[];
  user:User;//get user
  giveReview:boolean = false;
  orderline:Orderline=<Orderline>{};
  product:Product=<Product>{};
  review:Review = <Review>{};

  islogin:boolean = false;
  userid:number = 0;
  

  constructor(private orderService:OrderService, private reviewService:ReviewService,
    private authService: AuthService) { }

  ngOnInit(): void {
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
    this.orderService.getAllOrdersOfUser(this.userid).subscribe(res=>{
      this.orders = res;
      let noOfOrders = this.orders.length;
      for(let i=0; i<noOfOrders; i++){
        this.orderlines.push(this.orders[i].orderlines);
        this.deliveryAddress.push(this.orders[i].deliveryAddress);
      }
      console.log(this.deliveryAddress);
    });
  }

  onReviewClick(orderline:Orderline){
    this.orderline = orderline;
    console.log(this.orderline);
    this.product =this.orderline.product;
    console.log(this.product);

  }

  onReviewSubmit(){
    this.review.userid = this.userid;
    this.review.orderlineid = this.orderline.orderlineid;
    this.review.productid = this.product.productid;
    this.reviewService.postReview(this.review).subscribe(res=>{
      console.log(res);
      alert("Review Posted, thank you!!");
      window.location.reload();
    });

  }


}
