import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CascadelistService {

  constructor(private http:HttpClient) { }

  url_ = 'assets/store.json';
  getAll():any{
    return this.http.get<any>(this.url_);
  }
}
