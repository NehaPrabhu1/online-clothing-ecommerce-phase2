import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './components/products/products.component';
import { OrdersComponent } from './components/orders/orders.component';
import { HttpClientModule,  HTTP_INTERCEPTORS  } from '@angular/common/http';
import { ProductComponent } from './components/product/product.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LogoComponent } from './components/logo/logo.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { CartComponent } from './components/cart/cart.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { DeliveryaddressComponent } from './components/deliveryaddress/deliveryaddress.component';
import { ReviewComponent } from './components/review/review.component';
import { AdmindashboardComponent } from './components/admin/admindashboard/admindashboard.component';
import { AdmindashboarddiscountComponent } from './components/admin/admindashboarddiscount/admindashboarddiscount.component';
import { AdmindashboardproductComponent } from './components/admin/admindashboardproduct/admindashboardproduct.component';
import { AdminheaderComponent } from './components/admin/adminheader/adminheader.component';
import { LoginComponent } from './components/login/login.component';
import { HttpInterceptorService } from './services/basicauth.service';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    OrdersComponent,
    ProductComponent,
    HeaderComponent,
    FooterComponent,
    LogoComponent,
    NavigationComponent,
    CartComponent,
    HomeComponent,
    DeliveryaddressComponent,
    ReviewComponent,
    AdmindashboardComponent,
    AdmindashboarddiscountComponent,
    AdmindashboardproductComponent,
    AdminheaderComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
