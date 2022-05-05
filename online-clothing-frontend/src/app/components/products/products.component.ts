import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { BrandService } from 'src/app/services/brand.service';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products!:Product[];
  query = '';
  pgnum = 0;
  size=6;
  total:number = 0;
  totalPages:number=1;
  pages:number[] = [];
  pagination:boolean=false;
  title:String;

  constructor(private productService:ProductService, private route:ActivatedRoute,
    private brandService:BrandService, private categoryService:CategoryService) { }

  ngOnInit(): void {
   
    let path = this.route.snapshot.routeConfig?.path;
    if(path?.includes("gender")){
      let gender = this.route.snapshot.params['gender'];
      this.productService.getProductsByGender(gender).subscribe(res=>{
        this.products = res;
        this.title = gender + "'s Apparel"
        console.log(res);
      }); 
    }
    else if(path?.includes("search")){
      this.route.queryParams
      .subscribe(params => {
      this.query= params?.['q'];
      console.log(this.query);
      this.productService.searchProducts(this.query).subscribe(res=>{
        this.products = res;
        this.title = this.query;
        console.log(res);
      });
      });

    }
    else if(path?.includes("brand")){
      let id = parseInt(this.route.snapshot.params['id']);
      this.brandService.getProductsByBrandId(id).subscribe(res=>{
        this.products = res;
        this.title = this.products[0].brand.brandName;
      });

    }
    else if(path?.includes("category")){
      let id = parseInt(this.route.snapshot.params['id']);
      this.categoryService.getProductsByCategoryId(id).subscribe(res=>{
        this.products = res;
        this.title = this.products[0].category.categoryGender.concat(" ",this.products[0].category.categoryName.toString());
      });

    }
    else if(path?.includes("page")){
      this.pagination=true;
      this.route.queryParams.subscribe(params=>{
        this.pgnum = parseInt(params?.['pgnum']);
        this.size = parseInt(params?.['size']);
        this.productService.getProductCount().subscribe(res=>{
          this.total = res;
          this.totalPages = Math.ceil(this.total/this.size);
          if(this.pages.length == this.totalPages){
            for(let i=0;i<this.totalPages;i++){
              this.pages.pop();
            }
          }
          for(let i=0;i<this.totalPages;i++){
            this.pages.push(i);
          }
          console.log(this.pages);
          this.productService.getProductsByPage(this.pgnum,this.size).
          subscribe(res=>{
          this.products = res;
          this.title = "All Apparel"
        });
        });
        
      })
    }
    else{
      this.productService.getAllProducts().subscribe(res=>{
        this.products = res;
        this.title = "All Apparel"
        console.log(res);
      });
    }
    

  }

}



