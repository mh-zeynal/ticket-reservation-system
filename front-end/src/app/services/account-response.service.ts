import { Injectable } from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AccountResponseService {
  public subject = new Subject<String>();
  constructor() { }

  sendMessage(message: string){
    this.subject.next(message);
  }
}
