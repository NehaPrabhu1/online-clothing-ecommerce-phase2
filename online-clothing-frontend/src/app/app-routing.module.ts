import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashboardComponent } from './components/admin/admindashboard/admindashboard.component';
import { AdmindashboarddiscountComponent } from './components/admin/admindashboarddiscount/admindashboarddiscount.component';
import { AdmindashboardproductComponent } from './components/admin/admindashboardproduct/admindashboardproduct.component';
import { CartComponent } from './components/cart/cart.component';
import { DeliveryaddressComponent } from './components/deliveryaddress/deliveryaddress.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { OrdersComponent } from './components/orders/orders.component';
import { ProductComponent } from './components/product/product.component';
import { ProductsComponent } from './components/products/products.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'products',component:ProductsComponent},
  {path:'products/search',component:ProductsComponent},
  {path:'products/page',component:ProductsComponent},
  {path:'products/brand/:id',component:ProductsComponent},
  {path:'products/category/:id',component:ProductsComponent},
  {path:'products/gender/:gender',component:ProductsComponent},
  {path:'products/:id',component:ProductComponent},
  {path:'orders',component:OrdersComponent},
  {path:'cart',component:CartComponent},
  {path:'delivery-address',component:DeliveryaddressComponent},
  {path: 'admin', component:AdmindashboardComponent},
  {path: 'admin/discount', component:AdmindashboarddiscountComponent},
  {path: 'admin/products', component:AdmindashboardproductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
