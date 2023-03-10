import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatPresenterComponent } from './seat-presenter.component';

describe('SeatPresenterComponent', () => {
  let component: SeatPresenterComponent;
  let fixture: ComponentFixture<SeatPresenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeatPresenterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatPresenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
