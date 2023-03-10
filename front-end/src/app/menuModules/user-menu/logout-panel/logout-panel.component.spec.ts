import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoutPanelComponent } from './logout-panel.component';

describe('LogoutPanelComponent', () => {
  let component: LogoutPanelComponent;
  let fixture: ComponentFixture<LogoutPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogoutPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogoutPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
