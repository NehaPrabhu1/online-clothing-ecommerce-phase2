import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  username: String;
  password: String;
  user:User=<User>{};

  constructor(private http: HttpClient) { }

  login(username: String, password: String) {
    return this.http.get(`http://localhost:8080/api/v1/login`,
      { headers: { authorization: this.createBasicAuthToken(username, password)} }).
      pipe(map((res) => {
        console.log(res);
        this.username = username;
        this.password = password;
        localStorage.setItem('status','loggedin');
        this.registerSuccessfulLogin(username,password);
      }));
  }

  createBasicAuthToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password);
  }

  registerSuccessfulLogin(username:String, password:String) {
    sessionStorage.setItem("authenticatedUser", username.toString());
    sessionStorage.setItem("authenticatedUserPass",password.toString());
    this.http.get<User>('http://localhost:8080/api/v1/users/username/'+username).
    subscribe((res)=>{
      this.user = res;
      localStorage.setItem("currentUser",JSON.stringify(this.user));
      console.log(localStorage.getItem("currentUser"));
    });
  }

  getCurrentUser(){
    let user = null;
    let requiredStatus = "loggedin";
    let status = localStorage.getItem("status");
    if(status ===  requiredStatus){
      user = localStorage.getItem("currentUser"); //store the loggedin user
    }
    return user;
  }

  logout() {
    sessionStorage.removeItem("authenticatedUser");
    sessionStorage.removeItem("authenticatedUserPass");
    localStorage.removeItem("user");
    localStorage.removeItem("status");
    alert("You have logged out.");
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("authenticatedUser");
    if (user === null) return false
    return true
  }
}
