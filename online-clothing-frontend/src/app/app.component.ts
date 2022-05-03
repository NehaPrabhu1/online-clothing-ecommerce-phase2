import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LiveFashion';
  isAdmin:boolean = true;
  isLoggedIn:boolean= false;

  constructor() { }

  ngOnInit(): void {
    console.log("App component");
  }
}
