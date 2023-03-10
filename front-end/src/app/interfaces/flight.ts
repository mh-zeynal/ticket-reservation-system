import {Seat} from "./seat";

export interface Flight {
  id: number;
  type: string;
  departureDate: string;
  arrivalDate: string;
  seats: Seat[];
  seatService: string[];
}
