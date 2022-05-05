import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http:HttpClient) { }

  postReview(review:Review){
    return this.http.post<Review>('http://localhost:8080/api/v1/user/products/orders/review',review);
  }
}
