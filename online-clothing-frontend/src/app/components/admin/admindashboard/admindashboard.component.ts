import { Component, OnInit } from '@angular/core';
import { BrandService } from 'src/app/services/brand.service';
import { CategoryService } from 'src/app/services/category.service';
import { OrderService } from 'src/app/services/order.service';
import { ProductService } from 'src/app/services/product.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  productCount:number;
  userCount:number;
  salesCount:number = 0;
  orderCount:number;
  brandCount:number;
  categoryCount:number;

  constructor(private userService:UserService, private orderService:OrderService,
    private productService:ProductService, private brandService:BrandService,
    private categoryService:CategoryService) { }

  ngOnInit(): void {

    this.userService.getUsersCount().subscribe(res=>{
      this.userCount = res;
    });

    this.brandService.getBrandsCount().subscribe(res=>{
      this.brandCount = res;
    });

    this.categoryService.getCategoriesCount().subscribe(res=>{
      this.categoryCount = res;
    });

    this.orderService.getOrdersCount().subscribe(res=>{
      this.orderCount = res;
    });

    this.orderService.getOrderlineCount().subscribe(res=>{
      this.salesCount = res;
    });

    this.productService.getProductCount().subscribe(res=>{
      this.productCount = res;
    });
  }

}
