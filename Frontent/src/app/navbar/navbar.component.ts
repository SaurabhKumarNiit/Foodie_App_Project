import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import Swal from 'sweetalert2';
import { ProfileService } from '../services/profile.service';
import { Customer } from 'src/models/Customer';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  
  urllink:string = "https://nregsmp.org/eService/images/User.png";
  selectFiles(file:any){
    if(file.target.files){
      const reader = new FileReader()
      reader.readAsDataURL(file.target.files[0])
      reader.onload = (event:any)=>{
        this.urllink = event.target.result
      }
    }

  }


  public totalItem : number = 0;
  public searchTerm !: string;

  // currentGame: string ="";
  constructor(private cartService : CartService,private router:Router,private profileService:ProfileService ) { 
    // this.currentGame = JSON.parse(localStorage.getItem('currentGame')); 
  }

  customer: Customer = { customerName: '', email:'', password:'',mobileNo:'',profileDp:''};

  ngOnInit(): void {
    this.cartService.getCustomerCartData()
    .subscribe(res=>{
      this.totalItem = res.length;
    }),

    this.profileService.getSingleCustomer().subscribe(res=>{
      this.customer = res;
      this.urllink = this.customer.profileDp;
    })
  }

//   ngOnDestroy(){     
//     this.currentGame = null;   
// }


logIn(){
  if(localStorage.getItem('email')){
    this.router.navigateByUrl(''),

    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'First LogOut then LogIn agin!',
      
    })
    
  }else{
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Redirected To login page',
      showConfirmButton: false,
      timer: 1500
    })
  }
}


  logOut(){

    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, LogOut!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'LogOut!',
          'Your are Logout...',
          'success'
        ),
        localStorage.removeItem('email'),
          this.router.navigateByUrl('/login'),
          console.log("Log Out Success")
      }
    })
  }


}
