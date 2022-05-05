import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Brand } from 'src/app/models/brand';
import { Orderline } from 'src/app/models/orderline';
import { Product } from 'src/app/models/product';
import { Review } from 'src/app/models/review';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
product:Product=<Product>{};
brand:Brand=<Brand>{};
reviews:Review[];
reviewsPresent:Boolean= true;
sizes:string[] =['s','m','l','xl'];
sizeSelected:string = '';
orderline:Orderline=<Orderline>{};

  constructor(private route:ActivatedRoute, private productService:ProductService,
    private cartService:CartService, private router:Router) { }

  ngOnInit(): void {
    const id = parseInt(this.route.snapshot.params['id']);
    //console.log(this.route.snapshot.routeConfig?.path);
    this.productService.getProductById(id).subscribe((res)=>{
      console.log(res);
      this.product = res;
      this.brand = this.product.brand;
      this.reviews = this.product.productReviews;
      if(this.reviews.length == 0){
        this.reviewsPresent = false;
      }
      
    });


  }
  addToCart(){
    let islogin = localStorage.getItem("status") ? true : false;
    if(!islogin){
      alert("Login First");
      this.router.navigate(['login']);
    }
    else{
    this.orderline.productid = this.product.productid;
    this.orderline.quantity = 1;
    this.orderline.price =this.product.price *(1 -this.product.discount/100);
    this.orderline.size = this.sizeSelected;
    this.orderline.product = this.product;
    this.cartService.addItem(this.orderline);
    }

  }

}
