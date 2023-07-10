import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';
import { Item } from 'src/models/item';
import { Order } from 'src/models/order';
import { Customer } from 'src/models/Customer';

@Injectable({
  providedIn: 'root'
})
export class FoodAppService {

  URL: string = "http://localhost:8081/userproductservice/v1/user/orders";
  data2: any;

  constructor(private http: HttpClient) { }

  getOrders(): Observable<Array<Order>> {
    return this.http.get<Array<Order>>(this.URL);
  }

  getItems():Observable<Array<any>>{
    return this.http.get<Array<any>>(" http://localhost:9100/menu/getAllItem")
    .pipe(map((res:any)=>{
      return res;
    }))
  }

  getSingleOrder(id?: number): Observable<Order> {
    return this.http.get<Order>(`${"http://localhost:8081/userproductservice/v1/user/orders"}/${id}`);
  }





  registerCustomer(data:any) {
    console.log(data);
    return this.http.post<any>("http://localhost:8081/customerservice/v1/register",data);
  }

  loginCustomer(data:any):Observable<any>{
    return this.http.post<any>("http://localhost:8084/customer/v1/login",data);
  }

 
  
  

  addData(data: any) {
    return this.http.post<any>("http://localhost:8081/userproductservice/v1/register/", data);
  }

  UpdateOrder(id?: number, order?: Order) {
    return this.http.put<Order>(`${"http://localhost:8081/userproductservice/v1/user/updateOrder"}/${id}`, order);
  }

  DeleteNote(id?: number) {
    return this.http.delete<Order>(`${"http://localhost:8081/userproductservice/v1/userdata"}/${id}`);
  }

  createPayment(data: any) {
    return this.http.post<any>("http://localhost:8999/payment/create_order", data);
  }


  emailRequest(data: any) {
    return this.http.post<any>("http://localhost:9080/sendEmail", data);
  }

 
  getSingleItemByItemId(id?: number): Observable<Item> {
    return this.http.get<Item>(`${"http://localhost:9001/menu/items"}/${id}`);
  }


  getEmail(){
    return localStorage.getItem("email")
  }


  loginAdmin(data:any):Observable<any>{
    return this.http.post<any>("http://localhost:8085/admin/login",data);
  }


}
