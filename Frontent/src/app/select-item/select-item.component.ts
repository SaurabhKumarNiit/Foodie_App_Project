import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodAppService } from '../services/food-app.service';
import { Item } from 'src/models/item';
import { FavouriteService } from '../service/favourite.service';
import { CartService } from '../services/cart.service';
import { RestaurantService } from '../service/restaurant.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-select-item',
  templateUrl: './select-item.component.html',
  styleUrls: ['./select-item.component.css']
})
export class SelectItemComponent {

restaurant : any={restaurantId:'',restaurantName:'', restaurantLocation:'',imageUrl:'',rating:''};

item:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};
 


  constructor(private restaurantService:RestaurantService,private activateRoute: ActivatedRoute, private favouriteService:FavouriteService,
   private service:FoodAppService,private cartService:CartService,private router:Router){}



  ngOnInit(): void {
    
    this.activateRoute.paramMap.subscribe(params => {
      let  itemId = params.get('itemId') ??0;
      this.service.getSingleItemByItemId(+itemId).subscribe((data) => {
        this.item = data;     
      });
    });
  }

  
  addToFavourite(favouriteItem:Item){
    this.favouriteService.addToCustomerFavourite(favouriteItem).subscribe({

      next:data=>{
       
        Swal.fire("Congrats...!!!","Item Added to Favorite List...","success");

      },
      error:e=>{
        
        if(!localStorage.getItem('email')){
      
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'First LogIn then add to Favoutite!',
            
          }),
            this.router.navigateByUrl('/login');
          
        }else{
          Swal.fire("Sorry...!!!","Item Already Added to Favorite List...","error");
        }
         
      }

    });
  }

  addToCart(){

    this.cartService.addToCustomerCart(this.item).subscribe({

    next:data=>{

      console.log(data),
      Swal.fire({
        position: 'top',
        icon: 'success',
        title: 'Item Added to Cart...',
        showConfirmButton: false,
        timer: 1500
      })

    },
    error:e=>{
      if(!localStorage.getItem('email')){
      
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'First LogIn then add to Cart!',
          
        }),
          this.router.navigateByUrl('/login');
        
      }else{
        // Swal.fire("Sorry...!!!","Item Already Added to Cart...","error");
        
      }
    }

  });
   
  }

  time: number = 0;
  interval:any;
  play: boolean = false;


}
