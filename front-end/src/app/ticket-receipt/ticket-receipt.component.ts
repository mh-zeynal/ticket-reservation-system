import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { Location } from '@angular/common';
import {Router} from "@angular/router";
import {Ticket} from "../interfaces/ticket";

@Component({
  selector: 'app-ticket-receipt',
  templateUrl: './ticket-receipt.component.html',
  styleUrls: ['./ticket-receipt.component.scss']
})
export class TicketReceiptComponent implements OnInit {

  @ViewChild('ticketDiv') ticketDiv !: ElementRef;

  ticket!: Ticket;

  counter = 10;

  dialogue = `reservation succeeded (${this.counter})`;

  interval!: any;

  constructor(private location: Location, private router: Router) { }

  ngOnInit(): void {
    // @ts-ignore
    this.ticket = this.location.getState().ticket as Ticket;
    this.countDown();
  }

  countDown(){
    this.interval = setInterval(() => {
      this.counter -= 1;
      this.dialogue = `reservation succeeded (${this.counter})`;
      if (this.counter == -1)
        this.redirectToMenu();
    }, 1000);
  }

  redirectToMenu(){
    clearInterval(this.interval);
    this.router.navigateByUrl('/userMenu');
  }

}
