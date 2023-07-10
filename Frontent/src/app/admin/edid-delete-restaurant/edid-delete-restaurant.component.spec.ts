import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdidDeleteRestaurantComponent } from './edid-delete-restaurant.component';

describe('EdidDeleteRestaurantComponent', () => {
  let component: EdidDeleteRestaurantComponent;
  let fixture: ComponentFixture<EdidDeleteRestaurantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EdidDeleteRestaurantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EdidDeleteRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
