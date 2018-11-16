import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataTableTemplateComponent } from './data-table-template.component';

describe('DataTableTemplateComponent', () => {
  let component: DataTableTemplateComponent;
  let fixture: ComponentFixture<DataTableTemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataTableTemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataTableTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
