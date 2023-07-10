import { Component, OnInit } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import jwt_decode from 'jwt-decode';
import { AuthService } from '../services/auth.service';
import { FoodAppService } from '../services/food-app.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login-interface',
  templateUrl: './login-interface.component.html',
  styleUrls: ['./login-interface.component.css']
})
export class LoginInterfaceComponent implements  OnInit {
  
 
  constructor(private service : FoodAppService,private fb : FormBuilder, private router : Router
    ,private authService:AuthService,private snackBar:MatSnackBar) { }

  loginForm = this.fb.group({
    email: ['',Validators.required],
    password: ['',Validators.required]
  })
  get email() { return this.loginForm.get("email") }
  get password() { return this.loginForm.get("password") }

  ngOnInit(): void {
  }
 
  data: any;
  decodeData: any;
  userEmail : any;

  logindata(){
    this.service.loginCustomer(this.loginForm.value).subscribe(
      res => {
             console.log(res);
             this.data = res;

             console.log(this.data.token);
             this.decodeData = jwt_decode(this.data.token);
             console.log(this.decodeData);

             this.userEmail = this.decodeData.sub;
             console.log(this.email);
             localStorage.setItem('email',this.userEmail);
             localStorage.setItem('jwt',this.data.token);

             Swal.fire({
              title: 'You are Logged In Successfully',
              showClass: {
                popup: 'animate__animated animate__fadeInDown'
              },
              hideClass: {
                popup: 'animate__animated animate__fadeOutUp'
              }
            })

            this.router.navigateByUrl('/home');

            //  window.location.reload();
     },
     error=>
     {
      Swal.fire({
        icon: 'error',
        title: 'Failed...',
        text: 'Please Enter Correct Email and Password!',
      })
     }
     )   
  }


  logindataOfAdmin(){
    const data1 = this.loginForm.value;
    // console.log("data1",data1);
    if(data1.email =='admin@gmail.com' && data1.password =='@Admin123'){
      this.service.loginAdmin(data1).subscribe(
        (res:any) => {
              //  console.log(res);
               this.data = res;
  
               console.log(this.data.token);
               this.decodeData = jwt_decode(this.data.token);
              //  console.log(this.decodeData);
  
               this.userEmail = this.decodeData.sub;
              //  console.log(this.email);
               localStorage.setItem('email',this.userEmail);
               localStorage.setItem('jwt',this.data.token);
  
               Swal.fire({
                title: 'You are Logged In Successfully',
                showClass: {
                  popup: 'animate__animated animate__fadeInDown'
                },
                hideClass: {
                  popup: 'animate__animated animate__fadeOutUp'
                }
                });
  
               this.router.navigateByUrl('/admin');
       },
       error=>{
        Swal.fire({
          icon: 'error',
          title: 'Failed...',
          text: 'Please Enter Correct Email and Password!',
        })
       }
       )
    }
    
     
  }
  

}
