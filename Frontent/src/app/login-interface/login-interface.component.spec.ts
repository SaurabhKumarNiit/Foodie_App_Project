import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginInterfaceComponent } from './login-interface.component';

describe('LoginInterfaceComponent', () => {
  let component: LoginInterfaceComponent;
  let fixture: ComponentFixture<LoginInterfaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginInterfaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginInterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
