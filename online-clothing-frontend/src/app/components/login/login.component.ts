import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  username: string;
  password: string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;
  user:User;
  role:String;
  

  constructor(private authService:AuthService, private router:Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    let path = this.route.snapshot.routeConfig?.path;
    if(this.authService.isUserLoggedIn()){
      this.user = JSON.parse(this.authService.getCurrentUser()!);
        this.role = this.user.role;
      if(this.role === "user"){
        this.router.navigate(['']);
      }
      if(this.role === "admin"){
        this.router.navigate(['admin']);
      }


    }
  }

  handleLogin() {
    console.log(this.username,this.password);
    this.authService.login(this.username, this.password).subscribe((res) => {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful';
      alert("You have logged in successfully");
      window.location.reload();
      
    }, (error) => {
      console.log(error);
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
    
  }

}
