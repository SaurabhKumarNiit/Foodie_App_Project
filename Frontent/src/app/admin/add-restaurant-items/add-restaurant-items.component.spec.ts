import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRestaurantItemsComponent } from './add-restaurant-items.component';

describe('AddRestaurantItemsComponent', () => {
  let component: AddRestaurantItemsComponent;
  let fixture: ComponentFixture<AddRestaurantItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRestaurantItemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddRestaurantItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
