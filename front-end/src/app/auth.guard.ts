import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import {Observable} from 'rxjs';
import {AuthResponse} from "./interfaces/auth-response";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let res = true;
    if (localStorage.getItem('traUser') == null)
      res = false;
    return res;
  }

}
