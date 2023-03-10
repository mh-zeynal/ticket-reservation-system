import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpService} from "../../../services/http.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-ticket-panel',
  templateUrl: './ticket-panel.component.html',
  styleUrls: ['./ticket-panel.component.scss']
})
export class TicketPanelComponent implements OnInit {

  submitted = false;
  ticketGroup = new FormGroup({
    origin: new FormControl('', Validators.required),
    destination: new FormControl('', Validators.required),
    flightDate: new FormControl('', Validators.required)
  })

  constructor(private httpServ:HttpService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.submitted = true;
    if (!this.ticketGroup.valid)
      return;
    let origin = this.ticketGroup.controls['origin'].value;
    let destination = this.ticketGroup.controls['destination'].value;
    let date = this.ticketGroup.controls['flightDate'].value;
    this.router.navigate(['userMenu/flights'], {queryParams: {origin: origin, destination: destination, flightDate: date}})
  }

}
