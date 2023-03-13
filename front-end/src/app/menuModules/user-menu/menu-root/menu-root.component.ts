import {Component, HostListener, OnInit} from '@angular/core';
import {Permission} from "../../../interfaces/permission";
import {HttpService} from "../../../services/http.service";
import {menuBarAnimations} from "../../../animations/menuBar";
import {Platform} from "@angular/cdk/platform";

@Component({
  selector: 'app-menu-root',
  templateUrl: './menu-root.component.html',
  styleUrls: ['./menu-root.component.scss'],
  animations: menuBarAnimations.animation
})
export class MenuRootComponent implements OnInit {

  permissions!: Permission[];
  barFlag = true;
  isUserOnPhone = true;

  constructor(private httpServ: HttpService, private platform: Platform) {
  }

  ngOnInit(): void {
    this.httpServ.sendGetRequest<Permission[]>('/api/user/menu').subscribe(resp => {
      this.permissions = resp;
    })
    this.resizeWindow();
  }

  resizeWindow() {
    if (!this.platform.ANDROID && !this.platform.IOS)
      this.isUserOnPhone = false;
    else
      this.isUserOnPhone = true;
  }

  toggle(){
    this.barFlag = !this.barFlag;
    this.isUserOnPhone = !this.isUserOnPhone;
  }

  formatLink(permissionName: string){
    return permissionName.split(' ').join('-');
  }

}
