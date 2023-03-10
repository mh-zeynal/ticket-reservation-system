import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomSearchBoxInputComponent } from './custom-search-box-input.component';

describe('CustomSearchBoxInputComponent', () => {
  let component: CustomSearchBoxInputComponent;
  let fixture: ComponentFixture<CustomSearchBoxInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomSearchBoxInputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomSearchBoxInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
