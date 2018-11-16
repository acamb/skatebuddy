import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SkateBuddyHomeComponent } from './skate-buddy-home.component';

describe('SkateBuddyHomeComponent', () => {
  let component: SkateBuddyHomeComponent;
  let fixture: ComponentFixture<SkateBuddyHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SkateBuddyHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SkateBuddyHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
