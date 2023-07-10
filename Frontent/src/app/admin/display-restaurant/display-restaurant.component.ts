import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { CartService } from 'src/app/services/cart.service';
import { FoodAppService } from 'src/app/services/food-app.service';
import { SnackbarDisplayComponent } from 'src/app/snackbar-display/snackbar-display.component';
import { Item } from 'src/models/item';
import { Restaurant } from 'src/models/Restaurant';

@Component({
  selector: 'app-display-restaurant',
  templateUrl: './display-restaurant.component.html',
  styleUrls: ['./display-restaurant.component.css']
})
export class DisplayRestaurantComponent {





  
  restaurant: Restaurant[] = [];

  public resItems:any;

  restaurantItem:any;


  public searchTerm !: string;
  public totalItem : number = 0;

  public productList : any ;
  public filterCategory : any
  searchKey:string ="";
 

  constructor(private foodService:FoodAppService ,private cartService : CartService,
    private snackBar:MatSnackBar,private activateRoute:ActivatedRoute,private restaurantService:RestaurantService) { }


  ngOnInit(): void {
    // this.foodService.getItems().subscribe({
      this.restaurantService.getAllRsetaurant().subscribe({
      next:data=>{
        this.restaurant=data;
        this.productList =data;
        this.filterCategory=data;

      },
      error:e=>{
      alert("Failed due to Network Error");
      }
    })

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
      if(a.restaurantName == category || category==''){
        return a;
      }
    })
  }



}
