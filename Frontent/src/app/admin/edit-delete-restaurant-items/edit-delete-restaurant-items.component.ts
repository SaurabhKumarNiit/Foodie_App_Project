import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FavouriteService } from 'src/app/service/favourite.service';
import { ItemsService } from 'src/app/service/items.service';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { CartService } from 'src/app/services/cart.service';
import { FoodAppService } from 'src/app/services/food-app.service';
import { Item } from 'src/models/item';
import { Restaurant } from 'src/models/Restaurant';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-delete-restaurant-items',
  templateUrl: './edit-delete-restaurant-items.component.html',
  styleUrls: ['./edit-delete-restaurant-items.component.css']
})
export class EditDeleteRestaurantItemsComponent {




  


  restaurant : Restaurant={restaurantId:'',restaurantName:'', restaurantLocation:'',imageUrl:'',rating:''};

item:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};
 


  constructor(private restaurantService:RestaurantService,private activateRoute: ActivatedRoute,private itemService:ItemsService,
   private service:FoodAppService,private cartService:CartService,private router:Router){}



  ngOnInit(): void {
    
    this.activateRoute.paramMap.subscribe(params => {
      let  restaurantId = params.get('restaurantId') ??0;
      this.restaurantService.getSingleRestaurantByRestaurantId(+ restaurantId).subscribe((data) => {
        this.restaurant = data;     
      });
    }),

    this.activateRoute.paramMap.subscribe(params => {
      let  itemId = params.get('itemId') ??0;
      this.service.getSingleItemByItemId(+itemId).subscribe((data) => {
        this.item = data;     
      });
    });
  }

DeleteItem(){
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

    this.itemService.DeleteRestaurantItem(this.restaurant.restaurantId,this.item.itemId).subscribe({})
    this.itemService.DeleteMenuItem(this.item.itemId).subscribe({})
    this.router.navigateByUrl("/admin");

    // window.location.reload();
    Swal.fire(
      'Deleted!',
      'Your Item has been deleted.',
      'success'
    )
  }
})
}

UpdateItem(){
      this.itemService.UpdateRestaurantItem(this.restaurant.restaurantId,this.item).subscribe({

        next:data=>{

          this.itemService.UpdateMenuItem(this.item.itemId,this.item).subscribe({})
          Swal.fire({
            icon: 'success',
            title: 'Done',
            text: 'Your Item Successfully updated!'
          }),
          this.router.navigateByUrl("/admin");
          
        },
        error:e=>{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!'
          })
        }


      })
      
  
      // window.location.reload();
  
  }

}
