import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotUsernameComponent } from './forgot-username.component';

describe('ForgotUsernameComponent', () => {
  let component: ForgotUsernameComponent;
  let fixture: ComponentFixture<ForgotUsernameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ForgotUsernameComponent]
    });
    fixture = TestBed.createComponent(ForgotUsernameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
