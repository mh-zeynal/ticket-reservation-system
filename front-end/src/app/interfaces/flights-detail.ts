import {Flight} from "./flight";

export interface FlightsDetail {
  flightsList: Flight[];
  origin: string;
  destination: string;
}
