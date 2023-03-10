import {Seat} from "./seat";

export interface Ticket {
  seat: Seat;
  origin: string;
  lastname: string;
  firstname: string;
  arrivalDate: string;
  destination: string;
  departureDate: string;
}
