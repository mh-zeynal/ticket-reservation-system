import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  public sendPostRequest<T>(url: string, data: any): Observable<T>{
    return this.http.post<T>(url, data)
  }

  public sendGetRequest<T>(url: string){
    return this.http.get<T>(url);
  }
}
