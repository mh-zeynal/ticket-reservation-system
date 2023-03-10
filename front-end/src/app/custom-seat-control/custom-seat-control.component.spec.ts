import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomSeatControlComponent } from './custom-seat-control.component';

describe('CustomSeatControlComponent', () => {
  let component: CustomSeatControlComponent;
  let fixture: ComponentFixture<CustomSeatControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomSeatControlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomSeatControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
