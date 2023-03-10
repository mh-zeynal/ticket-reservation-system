import { Injectable } from '@angular/core';
import {Subject} from "rxjs";
import {Seat} from "../interfaces/seat";

@Injectable({
  providedIn: 'root'
})
export class SeatSelectService {
  public subject = new Subject<Seat>();

  constructor() { }
}
