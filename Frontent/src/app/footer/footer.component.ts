import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {

  insideFacebook:boolean;
  insideWhatsapp:boolean;
  insideInstagram:boolean;
  insideYoutube:boolean;

  constructor(){
    this.insideFacebook=false;
    this.insideInstagram=false;
    this.insideWhatsapp=false;
    this.insideYoutube=false;
  }

  showInside1(show:boolean){
    this.insideFacebook=show;
  }
  showInside2(show:boolean){
    this.insideWhatsapp=show;
  }
  showInside3(show:boolean){
    this.insideInstagram=show;
  }
  showInside4(show:boolean){
    this.insideYoutube=show;
  }
}
