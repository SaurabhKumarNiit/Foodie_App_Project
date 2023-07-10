import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/models/Customer';
import { Address } from 'src/models/Address';
import { ProfileService } from '../services/profile.service';
import Swal from 'sweetalert2';




@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent{
  constructor(private activateRoute: ActivatedRoute, private fb:FormBuilder,private _snackBar:MatSnackBar,
    private service:ProfileService,private route:Router){}

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



  submitStatus:any;
 orders: Customer[] = [];
  add:Address = {houseNo:'',landMark:'',city:'',zipCode:''};
  customer: Customer = { customerName: '', email:'', password:'',mobileNo:'',profileDp:'',address:this.add};

  urlId:any

  getId(){
    let urllink:any = this.customer.profileDp;
    this.urlId = urllink;
    alert(this.urlId);
  }


  ngOnInit(): void {

    this.service.getSingleCustomer().subscribe(data =>{
       this.customer = data;
      this.urllink = this.customer.profileDp;
    })
  }

  updatedata(){

    Swal.fire({
      title: 'Do you want to save the changes?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {

        this.service.updateCustomerDetails(this.customer.email,this.customer).subscribe(
          response => {
            let updtaData = response;
  
            updtaData.customerName = this.customer.customerName;
            updtaData.email =
            updtaData.profileDp = this.urllink;
            console.log(updtaData);
          }
        )
        
        Swal.fire('Saved!', '', 'success')
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info')
      }
    })
  }

}
