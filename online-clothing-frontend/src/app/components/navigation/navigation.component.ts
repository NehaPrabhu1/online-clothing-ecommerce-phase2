import { Component, OnInit } from '@angular/core';
import { Brand } from 'src/app/models/brand';
import { BrandService } from 'src/app/services/brand.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  searchTerm='';
  brands!:Brand[];
  itemInCart:number = 0;
  constructor(private brandService:BrandService, private cartService:CartService) { }

  ngOnInit(): void {
    this.brandService.getAllBrands().subscribe(res=>{
      this.brands = res;
      this.cartService.cartItems.subscribe(d=>{
        this.itemInCart = d.length;
      });
    });
    
  }

}
