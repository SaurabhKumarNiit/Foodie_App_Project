import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { RestaurantService } from 'src/app/service/restaurant.service'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.css']
})
export class AddRestaurantComponent {
  addRestaurant = new FormGroup({
    // restaurantId: new FormControl(''),
    restaurantName : new FormControl(''),
    restaurantLocation : new FormControl(''),
    imageUrl:new FormControl(''),
    rating:new FormControl(''),
  })

  // restaurant:any[]=[]

  restaurant : any={restaurantId:'',restaurantName:'', restaurantLocation:'',imageUrl:'',rating:''};
  constructor(private restaurantService:RestaurantService,private router:Router){}

  public totalRestro : number = 0;
  
  ngOnInit():void{
    this.restaurantService.getAllRsetaurant().subscribe({
      next:data=>{
        this.restaurant=data;
        

      },
      error:e=>{
      alert("Failed due to Network Error");
      }
    })

  }

  createRestro(){
    // console.log(this.addRestaurant.value);



    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, add it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {

        this.restaurantService.addRestaurant(this.addRestaurant.value).subscribe((result)=>{
          console.log("Get Restro",result);
        })

        swalWithBootstrapButtons.fire(
          'Added!',
          'Your Restaurant has been Added.',
          'success'
        ),
        this.router.navigateByUrl("/admin")
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        )
      }
    })
  }

  

}
