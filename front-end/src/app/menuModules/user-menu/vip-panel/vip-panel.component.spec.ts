import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VipPanelComponent } from './vip-panel.component';

describe('VipPanelComponent', () => {
  let component: VipPanelComponent;
  let fixture: ComponentFixture<VipPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VipPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VipPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
