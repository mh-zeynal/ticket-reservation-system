import {Flight} from "./flight";

export interface ReservationDetails {
  originPlace: string;
  destinationPlace: string;
  flight: Flight;
  date: string;
}
