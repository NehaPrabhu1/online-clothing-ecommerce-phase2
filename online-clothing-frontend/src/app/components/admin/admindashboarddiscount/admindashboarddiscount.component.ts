import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/category';
import { Discount } from 'src/app/models/discount';
import { ApiService } from 'src/app/services/api.service';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-admindashboarddiscount',
  templateUrl: './admindashboarddiscount.component.html',
  styleUrls: ['./admindashboarddiscount.component.css']
})
export class AdmindashboarddiscountComponent implements OnInit {

  discount: Discount= <Discount>{};
  categories:Category[]=[];
  discountData:Discount[]=[];
  constructor(private api : ApiService,
    private categoryService :CategoryService) { }

  ngOnInit(): void {
    this.api.getDiscount().subscribe((data)=>{
      this.discountData=data;  },
    (error)=>{
      console.log(error);},
    ()=>{});
   
    this.categoryService.getAllCategories().subscribe((data)=>{
     this.categories=data;
     console.log(this.categories);},
   (error)=>{
     console.log(error);},
   ()=>{});
  }

  validate():boolean{
    let isValid = true;
    if(this.discount.categoryid == 0 || this.discount.categoryid == null){
      isValid = false;
    }
    if(this.discount.startDate == null || this.discount.startTime == null){
      isValid = false;
    }
    if(this.discount.endDate == null || this.discount.endTime == null){
      isValid = false;
    }
    if(this.discount.discountPercent == null || this.discount.discountPercent <= 0){
      isValid = false;
    }
    
   return isValid;
   }

  postDiscountDetails(){
    let valid = this.validate();
    if(valid){
    console.log(this.discount);
     this.api.postDiscount(this.discount).subscribe(res=>{
        console.log(res)
       alert("Discount Added Successfully");},
       error=>{
        console.log(error); 
      alert("Discount not added")});
      window.location.reload();
       }
       else{
        alert("Enter proper product details. Do not keep any field empty");
       }
   }
   
 
    getAllDiscount(){
     this.api.getDiscount().subscribe(res=>{
       this.discountData = res; });
    }

}
