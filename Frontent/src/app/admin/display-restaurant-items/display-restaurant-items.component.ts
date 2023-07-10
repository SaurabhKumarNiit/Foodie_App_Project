import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { FavouriteService } from 'src/app/service/favourite.service';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { CartService } from 'src/app/services/cart.service';
import { FoodAppService } from 'src/app/services/food-app.service';
import { Item } from 'src/models/item';

@Component({
  selector: 'app-display-restaurant-items',
  templateUrl: './display-restaurant-items.component.html',
  styleUrls: ['./display-restaurant-items.component.css']
})
export class DisplayRestaurantItemsComponent {

  panelOpenState = false;

  items : Item[]=[];

item:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};

itemOfCart:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};

 restaurantIds: any=0;

 
 public searchTerm !: string;
 public totalItem : number = 0;

 public productList : any ;
 public filterCategory : any
 searchKey:string ="";

  public restaurants: any = [];

  constructor(private restaurantService:RestaurantService,private activateRoute: ActivatedRoute, private favouriteService:FavouriteService,
    private snackBar:MatSnackBar,private service:FoodAppService,private cartService:CartService){}

  ngOnInit(): void {

     this.activateRoute.paramMap.subscribe(params => {
        let restaurantId = params.get('restaurantId') ??0
      this.restaurantService.getItemsOfRestaurantByRestaurantId(+restaurantId).subscribe((data) => {
        this.items = data;
        this.productList=data;
        this.filterCategory=data;
        this.restaurantIds=restaurantId;

        this.cartService.search.subscribe((val:any)=>{
          this.searchKey = val;
        })

        
      })
    }),

    this.restaurantService.getSingleRestaurantByRestaurantId(this.restaurantIds).subscribe((data)=>{
      this.restaurants=data;
    

    })
   
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
