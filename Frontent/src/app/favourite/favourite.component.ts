import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Item } from 'src/models/item';
import Swal from 'sweetalert2';
import { FavouriteService } from '../service/favourite.service';;

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent {

  public favourites : Item[]=[];

  items:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:''};

  constructor(private favouriteService : FavouriteService,private snackBar:MatSnackBar) { }

  ngOnInit(): void {
    this.favouriteService.getCustomerFavourite()
    .subscribe(res=>{
      this.favourites = res;
      this.items=res;

      // this.grandTotal = this.cartService.getTotalPrice();
    })
  }

  removeItem(item:string){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, remove it!'
    }).then((result) => {
      if (result.isConfirmed) { 
        this.favouriteService.DeleteFavourite(item).subscribe({}),

        Swal.fire(
          'Removed!',
          'Your Favourite has been removed.',
          'success'
        ),
        window.location.reload();
 
      }
    })

    // this.favouriteService.DeleteFavourite(item).subscribe({

    //   next:data=>{
    //     this.snackBar.open('Your Favourite Item Removed successfully', 'success', {​
    //       duration: 4000,​
    //       panelClass: ['mat-toolbar', 'mat-primary']​
    //       })

    //   }
    //   ,
    //   error:e=>{
    //     this.snackBar.open('Your Favourite Item Not Removed', 'failed', {​
    //       duration: 4000,​
    //       panelClass: ['mat-toolbar', 'mat-primary']​
    //       })
    //   }

    // });
  }

}
