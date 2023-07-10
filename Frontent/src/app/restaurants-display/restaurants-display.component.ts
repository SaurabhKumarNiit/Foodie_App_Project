import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Item } from 'src/models/item';
import { Restaurant } from 'src/models/Restaurant';
import { RestaurantService } from '../service/restaurant.service';
import { CartService } from '../services/cart.service';
import { FoodAppService } from '../services/food-app.service';
import { SnackbarDisplayComponent } from '../snackbar-display/snackbar-display.component';

@Component({
  selector: 'app-restaurants-display',
  templateUrl: './restaurants-display.component.html',
  styleUrls: ['./restaurants-display.component.css']
})
export class RestaurantsDisplayComponent {


  restaurant: Restaurant[] = [];

  public resItems:any;

  item:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};

  restaurantItem:any;


  public searchTerm !: string;
  public totalItem : number = 0;

  public productList : Restaurant[] = [];
  public filterCategory : Restaurant[] = [];
  searchKey:string ="";
 

  constructor(private foodService:FoodAppService ,private cartService : CartService,
    private snackBar:MatSnackBar,private activateRoute:ActivatedRoute,private restaurantService:RestaurantService) { }


  ngOnInit(): void {
    // this.foodService.getItems().subscribe({
      this.restaurantService.getAllRsetaurant().subscribe({
      next:data=>{
        this.restaurant=data;
        this.productList=data;
        this.filterCategory=data;

        this.cartService.search.subscribe((val:any)=>{
          this.searchKey = val;
        })

      },
 
      error:e=>{
      alert("Failed due to Network Error");
      }
    })

    // this.cartService.getProducts()
    // .subscribe(res=>{
    //   this.totalItem = res.length;
    // });
   
    // this.foodService.getItems()
    // .subscribe(res=>{
    //   this.productList = res;
    //   this.filterCategory=res;
 
    //   console.log(this.productList)
    // });

    // this.cartService.search.subscribe((val:any)=>{
    //   this.searchKey = val;
    // })
  }

  // addtocart(item:any){
  //   this.cartService.addtoCart(item);
  //   this.snackBar.openFromComponent(SnackbarDisplayComponent, {
  //     duration: 1000,
  //   });

  // }



  // addToCart(){
  //   this.cartService.addToCart(this.item).subscribe({

  //     next:data=>{
  //       this.snackBar.openFromComponent(SnackbarDisplayComponent, {
  //         duration: 1000,
  //       })
  //     }
  //     ,
  //     error:e=>{
  //       alert("Item Not Add to Favourite due to Network Error");
  //     }
  //   });
   
  // }


  // addToFavourite(){
   
  //   this.cartService.addToCart(this.restaurant.values).subscribe({

     
  //     next:data=>{
  //       this.snackBar.open('Your Item Added in Favourite successfully', 'success', {​
  //         duration: 5000,​
  //         panelClass: ['mat-toolbar', 'mat-primary']​
  //         })

  //     },
  //     error:e=>{
  //       alert("Item Not Add to Favourite due to Network Error");
  //     }

  //   });
   
  // }



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
