import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpService} from "../../../services/http.service";

@Component({
  selector: 'app-logout-panel',
  templateUrl: './logout-panel.component.html',
  styleUrls: ['./logout-panel.component.scss']
})
export class LogoutPanelComponent implements OnInit {

  constructor(private router: Router, private httpServ: HttpService) { }

  ngOnInit(): void {
    this.httpServ.sendGetRequest('api/account/logout').subscribe(resp => {
      this.doResponse();
    })
  }

  doResponse(){
    this.deleteLocals();
    this.router.navigateByUrl('/account');
  }

  deleteLocals(){
    localStorage.removeItem('traRole');
    localStorage.removeItem('traUser');
    localStorage.removeItem('traName');
  }

}
