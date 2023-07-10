import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDeleteRestaurantItemsComponent } from './edit-delete-restaurant-items.component';

describe('EditDeleteRestaurantItemsComponent', () => {
  let component: EditDeleteRestaurantItemsComponent;
  let fixture: ComponentFixture<EditDeleteRestaurantItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditDeleteRestaurantItemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditDeleteRestaurantItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
