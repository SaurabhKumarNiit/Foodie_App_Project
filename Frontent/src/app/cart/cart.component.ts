import { Component, Inject, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service'; 
import { Item } from 'src/models/item';
import * as $ from 'jquery';
import Swal from 'sweetalert2';
declare var Razorpay: any;


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

 public products: Item[]=[];

//  cartItem:Item = {itemId:'',itemName:'',itemPrice:'', description:'', imagePath:'',itemType:'',quantity:0};

  public grandTotal !: number;

  constructor(private cartService : CartService) { }


  ngOnInit(): void {
    this.cartService.getCustomerCartData()
    .subscribe(res=>{
      this.products = res;
      for(let itemPrice of this.products){

        this.totalCost += itemPrice.itemPrice*itemPrice.quantity;

      }  
      this.grandTotal = this.cartService.getTotalPrice();
    })
  }



  removeItem(item:string){
        Swal.fire({
          title: 'Are you sure?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
          if (result.isConfirmed) {
            this.cartService.DeleteItem(item).subscribe({}),
            Swal.fire(
              'Deleted!',
              'Your Item has been deleted.',
              'success'
            ),
            window.location.reload();
          }
        })
      }

 public emptycart(){

  Swal.fire({
    title: 'Are you sure?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete all!'
  }).then((result) => {
    if (result.isConfirmed) {
      this.cartService.DeleteAllCartItems().subscribe({}),
      Swal.fire(
        'Deleted!',
        'Your All itms has been deleted.',
        'success'
      ),
      window.location.reload();
    }
  })
  }
  getTotal(){
    // alert(this.totalCost*this.products.quantity)
  }

  total:number=0;
  getCount(itemName: any) {
    
    return this.menuList1.filter(o => o.itemName === itemName).length;
  }
  menuList1:Item[]=[]
  increase(pass:any,event: any){
    
  
      this.menuList1.push(pass);
      // this.price();
      // console.log("Menulist",this.menuList1);
      this.totalCost+=pass.itemPrice;
  }
  totalCost:number=0;


price(){
  // if(this.menuList1.length==0+1){
  //   this.totalCost=this.menuList1.find(x=> x.itemPrice);
  //   // this.totalCost=0;
  // }
  this.totalCost=this.menuList1.map(x=> x.itemPrice).reduce((x,y)=> x+y);

}

decrease(pass:any,index:number){
  
    // this.menuList1.pop();
    if(index!==-1){
      this.menuList1.splice(index,1);
    //   this.price();
    // console.log("Menulist Delete",this.menuList1);
    this.totalCost-=pass.itemPrice;
    }
    
}

updateQuantity(item:Item,quantity:number){

  
  this.cartService.updateQuantity(item,quantity).subscribe(res=> {

    console.log(res);
    location.reload();
  })

}


// quantity = 1;

quantity:number=1

  increaseQuantity(index:any) {
 
  
    
    // if(index!==-1){
    //   this.quantity++;
    // }  
  }

  decreaseQuantity() {
    if(this.quantity>1){
      this.quantity--;
    }
    
  }

order(){
  Swal.fire({
    title: 'Do you want to save order or need changes?',
    showDenyButton: true,
    showCancelButton: true,
    confirmButtonText: 'Save',
    denyButtonText: `Don't save`,
  }).then((result) => {
    /* Read more about isConfirmed, isDenied below */
    if (result.isConfirmed) {
      Swal.fire('Saved!', '', 'success')
      this.paymentStart();
    }
     else if (result.isDenied) {
      Swal.fire('Changes are not saved', '', 'info')
    }
  })
}



  paymentStart(){
    console.log("payment started --")
    let amount= this.totalCost*this.quantity;
    console.log(amount);
  
  $.ajax(
    {
      url:'http://localhost:8999/payment/create_order/'+(localStorage.getItem('email')),
      data:JSON.stringify({amount:amount,info:'order_request'}),
      contentType:'application/json',
      type:'POST',
      dataType:'json',
      success:function(response){
        console.log(response);
  
        if(response.status=="created"){
  
          let options={
            key:'rzp_test_LP91fzOg59Pohi',
            amount:response.amount,
            currency:'INR',
            name:'Foodie App Payment Gateway',
            description:'Dilecious Food Hub',
            image:'https://images-platform.99static.com/O3ZHfJeHB741xpyYH95tWvMsdTI=/0x0:1279x1279/500x500/top/smart/99designs-contests-attachments/63/63966/attachment_63966256',
            order_id:response.id,
            "handler": function (response: { razorpay_payment_id: any; razorpay_order_id: any; razorpay_signature: any; }){
  
              console.log(response.razorpay_payment_id);
              console.log(response.razorpay_order_id);
              console.log(response.razorpay_signature);
  
              // console.log("payment successfull !!");
              // alert("Hurray ! Payment Done");
            
              Swal.fire(
                'Payment Done',
                'Your Order placed check your mail for order information',
                'success'
              )
          
             
          },
          prefill:{
  
            name:localStorage.getItem('customerName'),
  
            email:localStorage.getItem('email'),
  
            contact:localStorage.getItem('mobileNo')
  
          },
          notes:{
            address:"India MP"
          },
          theme:{
            color:"#3399cc"
          }
    
          };
  
          var rzp = new Razorpay(options);
          // this.emptycart();
  
         rzp.on('payment.failed',function(response: { error: { code: any; description: any; source: any; step: any; reason: any; metadata: { order_id: any; }; payment_id: any; }; }){
            alert(response.error.code);
            alert(response.error.description);
            alert(response.error.source);
            alert(response.error.step);
            alert(response.error.reason);
            alert(response.error.metadata.order_id)
            alert(response.error.payment_id)
            alert("Oops payment failed !!!!!!1")
         })
           rzp.open();

        }
      },
    
       error:function(error){
         console.log(error)
         alert("sonthing went wrong !!")
       }
    }
  )
    // this.sendEmail();
  
  };

}
