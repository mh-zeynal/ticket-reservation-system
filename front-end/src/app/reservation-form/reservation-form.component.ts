import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common";
import {Flight} from "../interfaces/flight";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpService} from "../services/http.service";
import {Ticket} from "../interfaces/ticket";
import {Router} from "@angular/router";

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.scss']
})
export class ReservationFormComponent implements OnInit {

  finalDataGroup = new FormGroup({
    firstname: new FormControl('', Validators.required),
    lastname: new FormControl('', Validators.required),
    seat: new FormControl(undefined, Validators.required)
  })
  origin!: string;
  destination!: string;
  flight!: Flight;
  submitted = false;

  constructor(private location: Location, private httpServ: HttpService, private router: Router) { }

  ngOnInit(): void {
    // @ts-ignore
    this.flight = this.location.getState().details.flight;
    // @ts-ignore
    this.origin = this.location.getState().details.origin;
    // @ts-ignore
    this.destination = this.location.getState().details.dest;
  }

  formatDate(date: string | undefined){
    let str = (date?.split('T')[1] as string)
    return str.substring(0, str.lastIndexOf(':'));
  }

  onSubmit(){
    this.submitted = true;
    if (!this.finalDataGroup.valid)
      return;
    let firstname = this.finalDataGroup.controls['firstname'].value;
    let lastname = this.finalDataGroup.controls['lastname'].value;
    let seat = this.finalDataGroup.controls['seat'].value;
    let obj: Ticket = {firstname: firstname, lastname: lastname, seat: seat,
      origin: this.origin, destination: this.destination,
      departureDate: this.flight.departureDate, arrivalDate: this.flight.arrivalDate}
    this.httpServ.sendPostRequest('/api/ticket/reserve', obj).subscribe(resp => {
      this.router.navigateByUrl('/receipt', {state: {ticket: obj}});
    })
  }

}
