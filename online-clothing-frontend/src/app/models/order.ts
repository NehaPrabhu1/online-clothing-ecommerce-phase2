import { Time } from "@angular/common";
import { DeliveryAddess } from "./deliveryaddress";
import { Orderline } from "./orderline";

export interface Order{
    orderid:number;
    userid:number;
    dateOfOrder:Date;
    timeOfOrder:Time;
    totalPayment:number;
    orderlines:Orderline[];
    deliveryAddress:DeliveryAddess;
}
