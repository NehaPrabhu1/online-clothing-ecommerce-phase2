import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor(private authService: AuthService) { }
  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authService.isUserLoggedIn() && req.url.indexOf('login') === -1) {
        const authReq = req.clone({
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': `Basic ${window.btoa(this.authService.username + ":" + this.authService.password)}`
            })
        });
        return next.handle(authReq);
    } 
    
    else if (this.authService.isUserLoggedIn() && req.url.indexOf('admin')) {
      let username:String = String(sessionStorage.getItem("authenticatedUser"));
      let password:String = String(sessionStorage.getItem("authenticatedUserPass"))
        const authReq = req.clone({
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': `Basic ${window.btoa(username+ ":" + password)}`
            })
        });
        return next.handle(authReq);
    } 
    
    
    else {
        return next.handle(req);
    }

   
}
}
