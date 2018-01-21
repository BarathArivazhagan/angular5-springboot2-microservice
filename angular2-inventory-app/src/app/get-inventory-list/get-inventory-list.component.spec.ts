import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetInventoryListComponent } from './get-inventory-list.component';

describe('GetInventoryListComponent', () => {
  let component: GetInventoryListComponent;
  let fixture: ComponentFixture<GetInventoryListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetInventoryListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetInventoryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
