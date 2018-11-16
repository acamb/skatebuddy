import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageWheelsComponent } from './manage-wheels.component';

describe('ManageWheelsComponent', () => {
  let component: ManageWheelsComponent;
  let fixture: ComponentFixture<ManageWheelsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageWheelsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageWheelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
