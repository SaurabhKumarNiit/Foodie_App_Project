import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Item } from 'src/models/item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList : any =[]
  public productList = new BehaviorSubject<any>([]);
  public search = new BehaviorSubject<string>("");
  data2: any;


  constructor(private http: HttpClient) { }

  getProducts(){
    return this.productList.asObservable();
  }

  setProduct(product : any){
    this.cartItemList.push(...product);
    this.productList.next(product);
  }

  // ------------------------------------

  addToCart(data: any) {
    this.cartItemList.push(data);
    this.productList.next(this.cartItemList);
    this.getTotalPrice();
    return this.http.post<any>("http://localhost:9003/cart/addToCart", data);
   
  }

  // getTotalPrice() : number{
  //   let grandTotal = 0;
  //   this.cartItemList.map((a:any)=>{
  //     grandTotal += a.itemPrice;
  //   })
  //   return grandTotal;
  // }

  
  getCartItems(): Observable<Array<any>> {
    return this.http.get<Array<any>>("http://localhost:9003/cart/getCartItems");
  }

  getSingleCartItemByItemId(id?: number): Observable<any> {
    return this.http.get<any>(`${" http://localhost:9003/cart/items"}/${id}`);
  }

  DeleteAllCartItems() {
    this.data2 = this.getEmail();
    return this.http.delete<any>(`${"http://localhost:8081/customerservice/v1/deleteAll"}/${this.data2}`);
  }

  DeleteItem(itemId?:string):Observable<any>{
    this.data2 = this.getEmail();
    return this.http.delete<any>(`${"http://localhost:8081/customerservice/v1/delete"}/${this.data2}/${itemId}`);
  }

  getEmail(){
    return localStorage.getItem("email")
  }

  addToCustomerCart(item:Item):Observable<any>{
    this.data2 = this.getEmail();
    return this.http.put<Item>(`${"http://localhost:8081/customerservice/v1/customer/addToCart"}/${this.data2}`,item)
  }

  getCustomerCartData():Observable<any>{
    this.data2 = this.getEmail();
    return this.http.get<any>(`${"http://localhost:8081/customerservice/v1/customer/cartItems"}/${this.data2}`)
  }


 // ------------------------------------

  addtoCart(product : any){
    this.cartItemList.push(product);
    this.productList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList)
  }
  getTotalPrice() : number{
    let grandTotal = 0;
    this.cartItemList.map((a:any)=>{
      grandTotal += a.itemPrice;
    })
    return grandTotal;
  }
  removeCartItem(product: any){
    this.cartItemList.map((a:any, index:any)=>{
      if(product.id== a.id){
        this.cartItemList.shift(index);
      }
    })
    this.productList.next(this.cartItemList);
  }
  removeAllCart(){
    this.cartItemList = []
    this.productList.next(this.cartItemList);
  }

  updateQuantity(item:Item,quantity:number){
    this.data2 = this.getEmail();
    return this.http.put<Item>(`${"http://localhost:8081/customerservice/v1/customer/updateQuantity"}/${this.data2}/${quantity}`,item)
  }
}
