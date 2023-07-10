import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from 'src/models/item';
import { Restaurant } from 'src/models/Restaurant';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  constructor(private http:HttpClient) { }

  DeleteRestaurantItem(restaurantId?:number,itemId?: number) {
    return this.http.delete<Item>(`${" http://localhost:9088/restaurant/v1/restaurant/delete"}/${restaurantId}/${itemId}`);
  }

  DeleteMenuItem(itemId?: number) {
    return this.http.delete<Item>(`${"http://localhost:9001/menu/deleteItem"}/${itemId}`);
  }

  UpdateRestaurantItem(restaurantId?:number,item?:Item){
    return this.http.put<Item>(`${"http://localhost:9088/restaurant/v1/restaurantItem/update"}/${restaurantId}`,item);
  }

  UpdateMenuItem(itemId?:number,item?:Item){
    return this.http.put<Item>(`${"http://localhost:9001/menu/updateItem"}/${itemId}`,item);
  }

  
}
