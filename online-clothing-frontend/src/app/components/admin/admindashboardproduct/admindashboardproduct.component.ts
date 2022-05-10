import { Component, OnInit } from '@angular/core';
import { Brand } from 'src/app/models/brand';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { BrandService } from 'src/app/services/brand.service';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-admindashboardproduct',
  templateUrl: './admindashboardproduct.component.html',
  styleUrls: ['./admindashboardproduct.component.css']
})
export class AdmindashboardproductComponent implements OnInit {

  products : Product[]=[];
  product: Product= <Product>{};
  brands:Brand[] =[];
  categories:Category []=[];

  constructor(private productService : ProductService, 
    private brandService: BrandService, 
    private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(res =>{
      this.products= res;
    });
    this.brandService.getAllBrands().subscribe(res=>{
      this.brands=res;
    });

    this.categoryService.getAllCategories().subscribe(res=>{
      this.categories=res;
    });
  }

  validate():boolean{
   let isValid = true;
   if(this.product.categoryid == 0 || this.product.categoryid == null){
     isValid = false;
   }
   if(this.product.brandid == 0 || this.product.brandid == null){
    isValid = false;
  }
   if(this.product.productName == null || this.product.productName == ''){
     isValid = false;
   }
   if(this.product.price == null || this.product.price <= 0){
     isValid = false;
   }
   if(this.product.color == null || this.product.color == ''){
    isValid = false;
  }
  if(this.product.productImage == null || this.product.productImage == ''){
    isValid = false;
  }
  return isValid;
  }

  postProductDetails(){
    let valid = this.validate();
    if(valid){
    this.productService.postProduct(this.product).subscribe(res =>{
      console.log(res);
      alert("product Added Successfully");
      window.location.reload();
    });
  }
  else{
    alert("Enter proper product details. Do not keep any field empty");
  }
  }

}
