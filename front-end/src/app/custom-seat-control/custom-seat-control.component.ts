import {Component, Input, OnInit} from '@angular/core';
import {Seat} from "../interfaces/seat";
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";
import {SeatSelectService} from "../services/seat-select.service";

@Component({
  selector: 'app-custom-seat-control',
  templateUrl: './custom-seat-control.component.html',
  styleUrls: ['./custom-seat-control.component.scss'],
  providers: [{
    provide: NG_VALUE_ACCESSOR,
    useExisting: CustomSeatControlComponent,
    multi: true
  }]
})
export class CustomSeatControlComponent implements OnInit, ControlValueAccessor {
  @Input() seats!: Seat[];
  val!: Seat;

  constructor(private seatServ: SeatSelectService) { }

  ngOnInit(): void {

  }

  onChange = (change: any) => {}

  onTouched = (onTouched: any) => {}

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  writeValue(obj: any): void {
    this.onChange(obj)
  }

  setState(event: Seat){
    this.val = event;
    this.onChange(this.val);
    this.seatServ.subject.next(this.val);
  }

}
