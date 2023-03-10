import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightReservationPanelComponent } from './flight-reservation-panel.component';

describe('FlightReservationPanelComponent', () => {
  let component: FlightReservationPanelComponent;
  let fixture: ComponentFixture<FlightReservationPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightReservationPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightReservationPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
