import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectWithStravaComponent } from './connect-with-strava.component';

describe('ConnectWithStravaComponent', () => {
  let component: ConnectWithStravaComponent;
  let fixture: ComponentFixture<ConnectWithStravaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectWithStravaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectWithStravaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
