import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmindashboarddiscountComponent } from './admindashboarddiscount.component';

describe('AdmindashboarddiscountComponent', () => {
  let component: AdmindashboarddiscountComponent;
  let fixture: ComponentFixture<AdmindashboarddiscountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdmindashboarddiscountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmindashboarddiscountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
