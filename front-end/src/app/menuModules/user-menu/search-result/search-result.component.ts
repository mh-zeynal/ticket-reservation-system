import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {Flight} from "../../../interfaces/flight";
import {FlightsDetail} from "../../../interfaces/flights-detail";

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.scss']
})
export class SearchResultComponent implements OnInit {

  @Input() flight!: Flight;

  @Input() origin!: string;

  @Input() destination!: string;

  @Output() select = new EventEmitter<object>();

  public dialogue!: string;

  constructor() { }

  ngOnInit(): void {
    this.setDialogue();
  }

  setDialogue(){
    let num = this.flight?.seats?.length;
    this.dialogue = num <= 10 ? `only ${num} seats remained` : `seats: ${num}`;
  }

  sendTicketToParent(){
    this.select.emit({flight: this.flight, origin: this.origin, dest: this.destination});
  }

  formatDate(date: string | undefined){
    let str = (date?.split('T')[1] as string)
    return str.substring(0, str.lastIndexOf(':'));
  }

}
