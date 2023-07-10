import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AddRestaurantItemsComponent } from './admin/add-restaurant-items/add-restaurant-items.component';
import { AddRestaurantComponent } from './admin/add-restaurant/add-restaurant.component';
import { AdminComponent } from './admin/admin.component';
import { DisplayRestaurantItemsComponent } from './admin/display-restaurant-items/display-restaurant-items.component';
import { DisplayRestaurantComponent } from './admin/display-restaurant/display-restaurant.component';
import { EdidDeleteRestaurantComponent } from './admin/edid-delete-restaurant/edid-delete-restaurant.component';
import { EditDeleteRestaurantItemsComponent } from './admin/edit-delete-restaurant-items/edit-delete-restaurant-items.component';
import { CartComponent } from './cart/cart.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { HomeComponent } from './home/home.component';
import { ItemsComponent } from './items/items.component';
import { LoginInterfaceComponent } from './login-interface/login-interface.component';
import { MenuItemComponent } from './menu-item/menu-item.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ProfileDataComponent } from './profile-data/profile-data.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterInterfaceComponent } from './register-interface/register-interface.component';
import { RestaurantItemsComponent } from './restaurant-items/restaurant-items.component';
import { RestaurantsDisplayComponent } from './restaurants-display/restaurants-display.component';
import { SelectItemComponent } from './select-item/select-item.component';
import { SnackbarDisplayComponent } from './snackbar-display/snackbar-display.component';


const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'login',component:LoginInterfaceComponent},
  {path:'register',component:RegisterInterfaceComponent},
  {path:'cart',component:CartComponent},
  {path:'item',component:ItemsComponent},
  {path:'item/:itemId',component:SelectItemComponent},
  {path:'restaurant/:restaurantId',component:RestaurantItemsComponent},
  {path:'restaurant/:restaurantId/:itemId',component:SelectItemComponent},
  {path:'menu',component:MenuItemComponent},
  {path:'favourite',component:FavouriteComponent},
  {path:'data/:email',component:ProfileComponent},
  {path:'profile',component:ProfileComponent},
  {path:'restaurant',component:RestaurantsDisplayComponent},
  {path:'about',component:AboutUsComponent},
  {path:'data',component:ProfileDataComponent},
  {path:'admin',component:AdminComponent},
  {path:'admin/addRestaurant',component:AddRestaurantComponent},
  {path:'admin/restaurants',component:DisplayRestaurantComponent},
  {path:'admin/restaurants/:restaurantId',component:EdidDeleteRestaurantComponent},
  {path:'admin/displayRestaurants',component:DisplayRestaurantComponent},
  {path:'admin/displayRestaurants/:restaurantId',component:AddRestaurantItemsComponent},
  // {path:'admin/addRestaurant',component:AddRestaurantComponent},
  {path:'admin/restaurantForitem',component:DisplayRestaurantComponent},
  {path:'admin/restaurantForitem/:restaurantId',component:DisplayRestaurantItemsComponent},
  {path:'admin/restaurantForitem/:restaurantId/:itemId',component:EditDeleteRestaurantItemsComponent},
  {path:'snack',component:SnackbarDisplayComponent},
  {path:'**',component:PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
