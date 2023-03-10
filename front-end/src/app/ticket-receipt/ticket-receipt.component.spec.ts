import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketReceiptComponent } from './ticket-receipt.component';

describe('TicketReceiptComponent', () => {
  let component: TicketReceiptComponent;
  let fixture: ComponentFixture<TicketReceiptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketReceiptComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketReceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
