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

  postProductDetails(){
    this.productService.postProduct(this.product).subscribe(res =>{
      console.log(res);
      alert("product Added Successfully");
      window.location.reload();
    });
  }

}
