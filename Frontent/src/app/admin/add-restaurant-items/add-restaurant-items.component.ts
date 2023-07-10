import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { Restaurant } from 'src/models/Restaurant';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-restaurant-items',
  templateUrl: './add-restaurant-items.component.html',
  styleUrls: ['./add-restaurant-items.component.css']
})
export class AddRestaurantItemsComponent {

  addItemForRestaurant = new FormGroup({
    itemId: new FormControl(''),
    itemName : new FormControl(''),
    itemPrice : new FormControl(''),
    itemType : new FormControl(''),
    description : new FormControl(''),
    imagePath:new FormControl('')
  })
  data: any;

  constructor(private restaurantService:RestaurantService,
    private activateRoute:ActivatedRoute,private _snackBar:MatSnackBar,private service:RestaurantService){}

  public totalRestro : number = 0;
  
  item:any = {itemId:'',itemName:'',itemPrice:'',description:'',imagePath:'',itemType:''};
  restaurant: Restaurant = { restaurantId: '', restaurantName:'', 
  restaurantLocation:'',imageUrl:'',rating:'',itemList:this.item};


  ngOnInit():void{
    this.activateRoute.paramMap.subscribe(params => { 
      let  restaurantId = params.get('restaurantId') ?? 0;
      this.service.getSingleRestaurantByRestaurantId(+ restaurantId).subscribe((data) => {
        this.restaurant = data;    
    })
  })
}

  addItemForSingleRestaurant(){


    Swal.fire({
      title: 'Do you want to save the changes?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
  
    this.restaurantService.addItem(this.restaurant.restaurantId,this.addItemForRestaurant.value).subscribe(
      res =>{
        this.data = res;
      }
    ),
        Swal.fire('Saved!', '', 'success')
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info')
      }
    })



  }

  addItemInRestaurant(){
    // console.log(this.addRestaurant.value);

    
  }

}
