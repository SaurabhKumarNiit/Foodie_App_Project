import { Item } from "./item";

export class Restaurant{
    restaurantId?:any;
    restaurantName?: any;
    restaurantLocation?:any;
    rating?:any;
    imageUrl?:any;
    itemList?:Item[];

    constructor(){
        this.restaurantId=0;
        this.restaurantName="";
        this.restaurantLocation="";
        this.imageUrl = "";
        this.rating = "";
        this.itemList=[];
    }
   
}