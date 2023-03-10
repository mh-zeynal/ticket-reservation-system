import {Component, Input, OnInit, Output, EventEmitter, ViewChild, ElementRef} from '@angular/core';
import {Seat} from "../interfaces/seat";
import {SeatSelectService} from "../services/seat-select.service";

@Component({
  selector: 'app-seat-presenter',
  templateUrl: './seat-presenter.component.html',
  styleUrls: ['./seat-presenter.component.scss']
})
export class SeatPresenterComponent implements OnInit {

  state!: string;
  stateVal!: boolean;
  @Input() seat!: Seat;
  @Output() choose = new EventEmitter<Seat>();
  @ViewChild('box') div!: ElementRef;

  constructor(private seatServ: SeatSelectService) { }

  ngOnInit(): void {
    this.stateVal = this.seat.reserved ? false : true;
    this.setState(this.seat?.reserved ? 'R' : 'E');
    this.seatServ.subject.subscribe(val => {
      if (!!this.div) {
        (this.div.nativeElement as HTMLElement).className =
          this.seat.seatNumber == val.seatNumber ? 'selected' : 'regular';
      }
      this.setState(this.seat.seatNumber == val.seatNumber ? 'S' : 'E');
    })
  }

  setState(val: string){
    this.state = val;
  }

  selectSeat(){
    this.choose.emit(this.seat);
  }

}
