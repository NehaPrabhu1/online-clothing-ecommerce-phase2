import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmindashboardproductComponent } from './admindashboardproduct.component';

describe('AdmindashboardproductComponent', () => {
  let component: AdmindashboardproductComponent;
  let fixture: ComponentFixture<AdmindashboardproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdmindashboardproductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmindashboardproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
