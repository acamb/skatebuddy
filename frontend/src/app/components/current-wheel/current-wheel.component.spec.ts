import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentWheelComponent } from './current-wheel.component';

describe('CurrentWheelComponent', () => {
  let component: CurrentWheelComponent;
  let fixture: ComponentFixture<CurrentWheelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrentWheelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentWheelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
