import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from 'src/models/item';
import { Restaurant } from 'src/models/Restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http: HttpClient) { }


  getAllRsetaurant(): Observable<Array<any>> {
    return this.http.get<Array<any>>("http://localhost:9088/restaurant/v1/getAllRestaurant");
  }

  getSingleRestaurantByRestaurantId(id?: number): Observable<any> {
    return this.http.get<any>(`${"http://localhost:9088/restaurant/v1/getRest"}/${id}`);
  }

  addRestaurant(data: any) {
    return this.http.post<any>("http://localhost:9088/restaurant/v1/restaurant/addRestaurant", data);
  }



  getItemsOfRestaurantByRestaurantId(id?: number): Observable<any> {
    return this.http.get<any>(`${"http://localhost:9088/restaurant/v1"}/${id}`);
  }


  DeleteAllCartItems() {
    return this.http.delete<Item>("http://localhost:9003/cart/deleteAll");
  }

  DeleteItem(itemId?: number) {
    return this.http.delete<Item>(`${"http://localhost:9003/cart/delete"}/${itemId}`);
  }


  DeleteSingleRestaurant(restaurantId?: number) {
    return this.http.delete<Item>(`${"http://localhost:9088/restaurant/v1/restaurant/delete"}/${restaurantId}`);
  }

  addItem(restaurantId:number,item?:any){
    return this.http.put<any>(`${"http://localhost:9088/restaurant/v1/restaurant/addMenu"}/${restaurantId}`,item);
  }

  updateRestaurantById(id?:number,restaurant?: Restaurant){
    return this.http.put<Restaurant>(`${"http://localhost:9088/restaurant/v1/updateRestaurant"}/${id}`,restaurant);
  }
}
