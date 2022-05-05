import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  getUsersCount(){
    return this.http.get<number>('http://localhost:8080/api/v1/admin/users/count');
  }
}
