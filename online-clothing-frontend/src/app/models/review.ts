import { User } from "./user";

export interface Review{
    reviewid:number;
    userid:number;
    orderlineid:number;
    productid:number;
    rating:number;
    review: String;
    user:User;
}