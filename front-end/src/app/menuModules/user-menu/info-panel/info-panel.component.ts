import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../../services/http.service";
import {User} from "../../../interfaces/user";

@Component({
  selector: 'app-info-panel',
  templateUrl: './info-panel.component.html',
  styleUrls: ['./info-panel.component.scss']
})
export class InfoPanelComponent implements OnInit {
  public data!: User;
  public passwordDisplay!: string;
  private flag = false;
  constructor(private httpServ:HttpService) { }

  ngOnInit(): void {
    this.httpServ.sendGetRequest<User>('/api/user/info').subscribe(resp => {
      this.doResponse(resp);
    })
  }

  doResponse(resp: User){
    this.data = resp;
    this.toggleDisplay();
  }

  toggleDisplay(){
    this.flag ? this.passwordDisplay = this.data.password : this.passwordDisplay = this.displayDots();
    this.flag = !this.flag;
  }

  displayDots(){
    let result = '';
    for (let i = 0; i < this.data.password.length; i++) {
      result += '●';
    }
    return result;
  }

}
