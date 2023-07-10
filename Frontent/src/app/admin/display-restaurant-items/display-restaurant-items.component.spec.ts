import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayRestaurantItemsComponent } from './display-restaurant-items.component';

describe('DisplayRestaurantItemsComponent', () => {
  let component: DisplayRestaurantItemsComponent;
  let fixture: ComponentFixture<DisplayRestaurantItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayRestaurantItemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayRestaurantItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
