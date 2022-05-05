import { Component } from '@angular/core';
import { User } from './models/user';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LiveFashion';
  isAdmin:boolean;
  isLoggedIn:boolean;
  user:User;
  role:String;

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
    if(this.authService.getCurrentUser() != null){
      this.user = JSON.parse(this.authService.getCurrentUser()!);
      this.isLoggedIn = true;
      this.role = this.user.role;
    if(this.role === "user"){
      this.isAdmin = false;
    }
    if(this.role === "admin"){
      this.isAdmin = true;
    }
    }

    
  }
}
