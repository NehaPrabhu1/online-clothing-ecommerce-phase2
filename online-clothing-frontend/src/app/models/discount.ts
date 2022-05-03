import { Time } from "@angular/common";

export interface Discount{
    discountid:number;
    categoryid:number;
    startDate:Date;
    startTime:Time;
    endDate:Date;
    endTime:Time;
    discountPercent:number;
    status:String;
}