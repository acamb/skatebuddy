import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddWheelComponent } from './add-wheel.component';

describe('AddWheelComponent', () => {
  let component: AddWheelComponent;
  let fixture: ComponentFixture<AddWheelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddWheelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddWheelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
