import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { data } from 'jquery';

import { Item } from 'src/models/item';
import { FavouriteService } from '../service/favourite.service';
import { RestaurantService } from '../service/restaurant.service';
import { CartService } from '../services/cart.service';
import { FoodAppService } from '../services/food-app.service';
import { SnackbarDisplayComponent } from '../snackbar-display/snackbar-display.component';



@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  items: Item[] = [];

  public resItems:any;

  item:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};

  restaurantItem:any;


  public searchTerm !: string;
  public totalItem : number = 0;

  public productList : any ;
  public filterCategory : any
  searchKey:string ="";
 

  constructor(private foodService:FoodAppService ,private cartService : CartService,
    private snackBar:MatSnackBar,private activateRoute:ActivatedRoute,private restaurantService:RestaurantService) { }


  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.totalItem = res.length;
    });
   
    this.foodService.getItems()
    .subscribe(res=>{
      this.productList = res;
      this.filterCategory=res;    
      console.log(this.productList)
    });

    this.cartService.search.subscribe((val:any)=>{
      this.searchKey = val;
    })
  }



  openSnackBar() {
   console.log("hello");
  }

  search(event:any){
    this.searchTerm = (event.target as HTMLInputElement).value;
    console.log(this.searchTerm);
    this.cartService.search.next(this.searchTerm);
  }

  filter(category:string){
    this.filterCategory = this.productList
    .filter((a:any)=>{
      if(a.itemType == category || category==''){
        return a;
      }
    })
  }
}
