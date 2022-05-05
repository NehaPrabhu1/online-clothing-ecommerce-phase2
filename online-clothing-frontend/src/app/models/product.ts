import { Brand } from "./brand";
import { Category } from "./category";
import { Review } from "./review";

export interface Product{
    productid:number;
    brand:Brand;
    category:Category;
    categoryid:number;
    brandid:number;
    productName:String;
    price:number;
    color:String;
    discount:number;
    productImage:String;
    productReviews:Review[];
}
