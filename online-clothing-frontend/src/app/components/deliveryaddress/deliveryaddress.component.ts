import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';
import { DeliveryAddess } from 'src/app/models/deliveryaddress';
import { Order } from 'src/app/models/order';
import { CartService } from 'src/app/services/cart.service';
import { CascadelistService } from 'src/app/services/cascadelist.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-deliveryaddress',
  templateUrl: './deliveryaddress.component.html',
  styleUrls: ['./deliveryaddress.component.css']
})
export class DeliveryaddressComponent implements OnInit {

  deliveryAddress:DeliveryAddess = <DeliveryAddess>{};

  order:Order=<Order>{}
  orderPlaced:Order;

  countries:any;
  cities:any;
  selectedCountry:any = {
   name:''
  };

  constructor(private dataservice:CascadelistService, private route:ActivatedRoute, 
    private router:Router, private orderService:OrderService, private cartService:CartService) { 
      //==> Using history state get data
      // this.route.queryParams.subscribe(params=>{
      //   console.log(this.router.getCurrentNavigation()?.extras.state);
      //   if (this.router.getCurrentNavigation()?.extras.state) {
      //      console.log(this.router.getCurrentNavigation()?.extras.state?['orderPlaced']:null);
      //   }
      // });
    }

  ngOnInit(): void {
    //==> using local storage get data
    this.order = this.orderService.getOrderCaptured();
    console.log(this.order);
    this.showAll();
    this.onSelect(this.selectedCountry.name);
  }

  showAll(){
    this.dataservice.getAll().subscribe(
      (data:any) => {
        this.countries = data;
        //console.log(this.countries);
      }
    )
  }
  onSelect(country_name:any){
    this.dataservice.getAll().subscribe((res:any)=>{
      this.cities = res['cities'].filter((res:any)=>res.country_name == country_name!.value);
      //console.log(this.cities);
    })
  }

  onSubmit(){
    this.order.deliveryAddress = this.deliveryAddress;
    this.orderService.postOrder(this.order).subscribe(res=>{
      console.log(res);
      let items:any = [];
      this.cartService.setCartData(items);
      alert("Order placed successfully");
      this.router.navigate(["orders"]);
    },
    (error)=>{
      alert("Order was not placed !!!");
    });

  }

}
