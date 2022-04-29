import { Product } from "./product";
import { Review } from "./review";

export interface Orderline{
    orderlineid:number;
    productid:number;
    product:Product;
    size:String;
    quantity:number;
    price:number;
    review:Review;
}