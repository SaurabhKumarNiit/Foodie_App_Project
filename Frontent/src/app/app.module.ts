import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterInterfaceComponent } from './register-interface/register-interface.component';
import { LoginInterfaceComponent } from './login-interface/login-interface.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatBadgeModule} from '@angular/material/badge';
import {MatButtonModule} from '@angular/material/button';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatCardModule} from '@angular/material/card';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {MatSelectModule} from '@angular/material/select';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatRadioModule} from '@angular/material/radio';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTabsModule} from '@angular/material/tabs';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MenuItemComponent } from './menu-item/menu-item.component';
import { CartComponent } from './cart/cart.component';
import { ItemsComponent } from './items/items.component';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { FilterPipe } from './Pipes/filter.pipe';
import { AboutUsComponent } from './about-us/about-us.component';
import { SelectItemComponent } from './select-item/select-item.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { SnackbarDisplayComponent } from './snackbar-display/snackbar-display.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { ProfileComponent } from './profile/profile.component';
import { RestaurantsDisplayComponent } from './restaurants-display/restaurants-display.component';
import { RestaurantItemsComponent } from './restaurant-items/restaurant-items.component';
import { AdminComponent } from './admin/admin.component';
import { AddRestaurantComponent } from './admin/add-restaurant/add-restaurant.component';
import { EdidDeleteRestaurantComponent } from './admin/edid-delete-restaurant/edid-delete-restaurant.component';
import { AddRestaurantItemsComponent } from './admin/add-restaurant-items/add-restaurant-items.component';
import { DisplayRestaurantComponent } from './admin/display-restaurant/display-restaurant.component';
import { DisplayRestaurantItemsComponent } from './admin/display-restaurant-items/display-restaurant-items.component';
import { EditDeleteRestaurantItemsComponent } from './admin/edit-delete-restaurant-items/edit-delete-restaurant-items.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterInterfaceComponent,
    LoginInterfaceComponent,
    AboutUsComponent,
    HomeComponent,
    PagenotfoundComponent,
    MenuItemComponent,
    CartComponent,
    ItemsComponent,
    NavbarComponent,
    FooterComponent,
    FilterPipe,
    SelectItemComponent,
    FavouriteComponent,
    SnackbarDisplayComponent,
    ProfileComponent,
    RestaurantsDisplayComponent,
    RestaurantItemsComponent,
    AdminComponent,
    AddRestaurantComponent,
    EdidDeleteRestaurantComponent,
    AddRestaurantItemsComponent,
    DisplayRestaurantComponent,
    DisplayRestaurantItemsComponent,
    EditDeleteRestaurantItemsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
     ReactiveFormsModule,
     BrowserAnimationsModule,
     MatBadgeModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatSelectModule,
  MatSidenavModule,
  MatToolbarModule,
  MatRadioModule,
  MatFormFieldModule,
  MatSnackBarModule,
  MatDatepickerModule,
  NgbModule,
  MatTabsModule,
  HttpClientModule,
  MatProgressSpinnerModule,
  MatProgressBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
