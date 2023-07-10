import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FavouriteService } from 'src/app/service/favourite.service';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { CartService } from 'src/app/services/cart.service';
import { FoodAppService } from 'src/app/services/food-app.service';
import { Item } from 'src/models/item';
import { Restaurant } from 'src/models/Restaurant';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edid-delete-restaurant',
  templateUrl: './edid-delete-restaurant.component.html',
  styleUrls: ['./edid-delete-restaurant.component.css']
})
export class EdidDeleteRestaurantComponent {





  restaurant : Restaurant={restaurantId:'',restaurantName:'', restaurantLocation:'',imageUrl:'',rating:''};

item:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};
 


  constructor(private restaurantService:RestaurantService,private activateRoute: ActivatedRoute, private favouriteService:FavouriteService,
   private service:FoodAppService,private cartService:CartService,private router:Router){}



  ngOnInit(): void {
    
    this.activateRoute.paramMap.subscribe(params => {
      let  restaurantId = params.get('restaurantId') ??0;
      this.restaurantService.getSingleRestaurantByRestaurantId(+ restaurantId).subscribe((data) => {
        this.restaurant = data;     
      });
    });
  }

DeleteRestaurant(){
Swal.fire({
  title: 'Are you sure?',
  text: "You won't be able to revert this!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Yes, delete it!'
}).then((result) => {
  if (result.isConfirmed) {

    this.restaurantService.DeleteSingleRestaurant(this.restaurant.restaurantId).subscribe({})
    this.router.navigateByUrl("/admin");

    // window.location.reload();
    Swal.fire(
      'Deleted!',
      'Your Restaurant has been deleted.',
      'success'
    )
  }
})
}

UpdateRestaurant(){
      this.restaurantService.updateRestaurantById(this.restaurant.restaurantId,this.restaurant).subscribe({

        next:data=>{

          Swal.fire({
            icon: 'success',
            title: 'Done',
            text: 'Restaurant Successfully updated!'
          })
          
        },
        error:e=>{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!'
          })
        }


      })
      this.router.navigateByUrl("/admin");
  
      // window.location.reload();
  
  }
  

}

// next:data=>{
//   this.restaurant=data;
//   this.productList =data;
//   this.filterCategory=data;

// },
// error:e=>{
// alert("Failed due to Network Error");
// }
