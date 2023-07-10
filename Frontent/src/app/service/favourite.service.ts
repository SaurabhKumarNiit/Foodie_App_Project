import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from 'src/models/item';

@Injectable({
  providedIn: 'root'
})
export class FavouriteService {
  data2: any;


  constructor(private http: HttpClient) { }

  addFavourite(favouriteItem: any) {
    return this.http.post<any>("http://localhost:8099/api/v1/fav/addfav", favouriteItem);
  }

  getFavourites(): Observable<Array<any>> {
    return this.http.get<Array<any>>("http://localhost:8099/api/v1/fav/getAllFavourites");
  }

  // DeleteFavourite(itemId?: number) {
  //   return this.http.delete<Item>(`${"http://localhost:8099/api/v1/fav/delete"}/${itemId}`);
  // }


  getEmail(){
    return localStorage.getItem("email")
  }

  addToCustomerFavourite(item:Item):Observable<any>{
    this.data2 = this.getEmail();
    return this.http.put<Item>(`${"http://localhost:8081/customerservice/v1/customer/addToFavourite"}/${this.data2}`,item)
  }

  getCustomerFavourite():Observable<any>{
    this.data2 = this.getEmail();
    return this.http.get<any>(`${"http://localhost:8081/customerservice/v1/customer/favourites"}/${this.data2}`)
  }

  
  DeleteFavourite(itemId?:string):Observable<any>{
    this.data2 = this.getEmail();
    return this.http.delete<any>(`${"http://localhost:8081/customerservice/v1/delete/favourite"}/${this.data2}/${itemId}`);
  }



}
