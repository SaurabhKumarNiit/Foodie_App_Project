import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, Validators } from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { FoodAppService } from '../services/food-app.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register-interface',
  templateUrl: './register-interface.component.html',
  styleUrls: ['./register-interface.component.css']
})
export class RegisterInterfaceComponent implements OnInit{

  urllink:string = "https://nregsmp.org/eService/images/User.png";
  selectFiles(event:any){
    if(event.target.files){
      const reader = new FileReader()
      reader.readAsDataURL(event.target.files[0])
      reader.onload = (event:any)=>{
        this.urllink = event.target.result
      }
    }
  }


  constructor(private fb:FormBuilder,private _snackBar:MatSnackBar,private service:FoodAppService,private route:Router){}
  ngOnInit(): void {
  }

  data:any;



  registrationForm = this.fb.group({
    customerName: ['',[Validators.required,Validators.minLength(5)]],
    email: ['',[Validators.required,Validators.email]],
    password: ['',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,30}$/)]],
    mobileNo: ['',[Validators.required,Validators.pattern(/^\+?\d{1,4}?[-.\s]?\(?\d{1,3}?\)?[-.\s]?\d{1,4}[-.\s]?\d{1,4}[-.\s]?\d{1,9}$/)]],
    address : this.fb.group({
      houseNo:['',[Validators.required]],
      landMark:['',[Validators.required]],
      city:['',[Validators.required]],
      zipCode:['',[Validators.required]],
    })
  });

  get customerName(){return this.registrationForm.get("customerName")}
  get email(){return this.registrationForm.get("email")}
  get password(){return this.registrationForm.get("password")}
  get mobileNo(){return this.registrationForm.get("mobileNo")}
  get houseNo(){return this.registrationForm.get("address.houseNo")}
  get landMark(){return this.registrationForm.get("address.landMark")}
  get city(){return this.registrationForm.get("address.city")}
  get zipCode(){return this.registrationForm.get("address.zipCode")}




  verifydata(){
    this.service.registerCustomer({
      customerName:this.customerName?.value,
      email:this.email?.value,
      password:this.password?.value,
      mobileNo:this.mobileNo?.value,
      profileDp:this.urllink,
      address:{
        houseNo:this.houseNo?.value,
        landMark:this.landMark?.value,
        city:this.city?.value,
        zipCode:this.zipCode?.value
      }
    }).subscribe(data =>{
      console.log(data);

      Swal.fire({
        title: 'You are registered SuccessFull Now you Log In with your Email & Password',
        showClass: {
          popup: 'animate__animated animate__fadeInDown'
        },
        hideClass: {
          popup: 'animate__animated animate__fadeOutUp'
        }
      })
      this.registrationForm.reset();
      this.route.navigateByUrl("/login")

    },
    error=>{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Something went wrong!',
      })
    }) 
  }

}
