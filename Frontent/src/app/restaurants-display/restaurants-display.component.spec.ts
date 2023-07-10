import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantsDisplayComponent } from './restaurants-display.component';

describe('RestaurantsDisplayComponent', () => {
  let component: RestaurantsDisplayComponent;
  let fixture: ComponentFixture<RestaurantsDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantsDisplayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestaurantsDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
