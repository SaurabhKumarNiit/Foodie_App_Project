import { Component } from '@angular/core';
import { OrderDetailsService } from '../service/order-details.service';

@Component({
  selector: 'app-menu-item',
  templateUrl: './menu-item.component.html',
  styleUrls: ['./menu-item.component.css']
})
export class MenuItemComponent {

  constructor(private service:OrderDetailsService) { }
  foodData:any;
  ngOnInit(): void {
    this.foodData = this.service.foodDetails;
  }
  

}
