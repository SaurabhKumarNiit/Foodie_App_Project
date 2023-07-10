import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from 'src/models/Customer';
import { Address } from 'src/models/Address';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

 data:any;

  constructor(private http:HttpClient) { }

  getEmail(){
    return localStorage.getItem("email")
  }

  getSingleCustomer(): Observable<Customer> {
    this.data = this.getEmail();
    return this.http.get<Customer>(`${"http://localhost:8081/customerservice/v1/customers"}/${this.data}`);
  }

  getCustomers():Observable<Array<Customer>>{
    return this.http.get<Array<Customer>>("http://localhost:8081/customerservice/v1/customers");
  }


  getSingleCustomerAddress(email?: string): Observable<Address> {
    return this.http.get<Address>(`${"http://localhost:8081/customerservice/v1/customers/address"}/${email}`);
  }


  updateCustomerDetails(email?: string, customer?: Customer) {
    return this.http.put<Customer>(`${"http://localhost:8081/customerservice/v1/customers/update"}/${email}`, customer);
  }


  // editNote(id?: number, order?: Order) {
  //   return this.http.put<Order>(`${"http://localhost:8081/userproductservice/v1/user/updateOrder"}/${id}`, order);
  // }
}
