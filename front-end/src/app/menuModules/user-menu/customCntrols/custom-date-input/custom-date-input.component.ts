import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";
import {ConnectionPositionPair} from "@angular/cdk/overlay";

@Component({
  selector: 'app-custom-date-input',
  templateUrl: './custom-date-input.component.html',
  styleUrls: ['./custom-date-input.component.scss'],
  providers: [{
    provide: NG_VALUE_ACCESSOR,
    useExisting: CustomDateInputComponent,
    multi: true
  }]
})
export class CustomDateInputComponent implements OnInit, ControlValueAccessor {

  public currentDay!: number;

  public selectedMonth !: string;

  public leftFlag = true;

  public rightFlag = false;

  public monthDays !: any[];

  private months = ['january', 'february', 'march',
    'april', 'may', 'june',
    'july', 'august', 'september',
    'october', 'november', 'december']

  @ViewChild('date_presenter') input !: ElementRef;

  isUserDropdownOpen = false;

  overlayPositionPairs: ConnectionPositionPair[] = [
    {
      offsetX: 0,
      offsetY: -20,
      originX: 'center',
      originY: 'top',
      overlayX: 'start',
      overlayY: 'bottom',
    },
  ];

  constructor() { }

  ngOnInit(): void {
    this.selectedMonth = this.months[new Date().getMonth()];
    this.currentDay = new Date().getDate();
    this.setMonthDays(0);
  }

  toggle(){
    this.isUserDropdownOpen = !this.isUserDropdownOpen;
  }

  setMonthDays(index: number){
    let dt = new Date();
    let month = dt.getMonth() + 1 + index;
    let year = dt.getFullYear();
    this.monthDays = new Array(new Date(year, month, 0).getDate());
    this.setMonth(index);
    this.toggleArrows();
  }

  setMonth(index: number){
    this.selectedMonth = this.months[new Date().getMonth() + index];
  }

  selectDate(day: number) {
    let month = this.months.indexOf(this.selectedMonth) + 1;
    let date = day + '/' + month + '/' + new Date().getFullYear();
    (this.input.nativeElement as HTMLInputElement).value = date;
    this.toggle();
    this.onChange(date);
  }

  toggleArrows(){
    this.leftFlag = !this.leftFlag;
    this.rightFlag = !this.rightFlag;
  }

  onChange = (change:any) => {}

  onTouched = (onTouched:any) => {}

  registerOnChange(fn: any) {
    this.onChange = fn;
  }

  registerOnTouched(fn: any) {
    this.onTouched = fn;
  }

  writeValue(obj: any) {
    this.onChange(obj);

  }

}
