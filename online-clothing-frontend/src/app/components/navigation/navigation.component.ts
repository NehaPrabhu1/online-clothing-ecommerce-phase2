import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Brand } from 'src/app/models/brand';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
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
  islogin:boolean;
  name:String = "Visitor";
  user:User;

  isAdmin:boolean = false;
  role:String;

  constructor(private brandService:BrandService, private cartService:CartService,
    private authService:AuthService, private router:Router) { 
    }

  ngOnInit(): void {
    this.islogin = localStorage.getItem("status") ? true : false;
      if(this.islogin){
        if(this.authService.getCurrentUser() != null){
          this.user = JSON.parse(this.authService.getCurrentUser()!);
          let role = this.user.role;       
        if(role === "user"){
          this.name = this.user.firstName;
          this.isAdmin = false;
        } 
        if(role === "admin"){
          this.isAdmin = true;
          this.router.navigate(['admin']);
        }
        }
      }
      else{
        this.router.navigate(['']);
      }
    this.brandService.getAllBrands().subscribe(res=>{
      this.brands = res;
      this.cartService.cartItems.subscribe(d=>{
        this.itemInCart = d.length;
      });
    });
  }

  logout(){
    this.authService.logout();
    window.location.reload();    
  }

  login(){
    this.router.navigate(['login']);
  }

}
