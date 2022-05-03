import { Product } from "./product";
import { Review } from "./review";

export interface Orderline{
    orderlineid:number;
    productid:number;
    product:Product;
    size:string;
    quantity:number;
    price:number;
    review:Review;
}