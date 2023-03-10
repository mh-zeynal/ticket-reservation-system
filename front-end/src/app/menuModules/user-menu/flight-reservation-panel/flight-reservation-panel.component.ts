import {ActivatedRoute, Router} from "@angular/router";
import {Component, OnInit} from '@angular/core';
import {Flight} from "../../../interfaces/flight";
import {FlightsDetail} from "../../../interfaces/flights-detail";
import {HttpService} from "../../../services/http.service";

@Component({
  selector: 'app-flight-reservation-panel',
  templateUrl: './flight-reservation-panel.component.html',
  styleUrls: ['./flight-reservation-panel.component.scss']
})
export class FlightReservationPanelComponent implements OnInit {

  public flightDetails!: FlightsDetail;

  constructor(private router: Router, private route: ActivatedRoute, private httpServ:HttpService) {}

  ngOnInit(): void {
    this.route.queryParams
      .subscribe(params => {
        this.httpServ.sendPostRequest<Flight[]>('/api/ticket/flights', params).subscribe(resp => {
          this.flightDetails = {flightsList: resp, origin: params.origin, destination: params.destination}
        })
        }
      );
  }

  reserveTicket(details: object){
    this.router.navigateByUrl('reserve', {state: {details: details}});
  }

}
