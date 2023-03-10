import {Component, HostListener, OnInit} from '@angular/core';
import {Permission} from "../../../interfaces/permission";
import {HttpService} from "../../../services/http.service";
import {menuBarAnimations} from "../../../animations/menuBar";

@Component({
  selector: 'app-menu-root',
  templateUrl: './menu-root.component.html',
  styleUrls: ['./menu-root.component.scss'],
  animations: menuBarAnimations.animation
})
export class MenuRootComponent implements OnInit {

  permissions!: Permission[];
  barFlag = true;
  buttonFlag = true;

  constructor(private httpServ: HttpService) {
  }

  ngOnInit(): void {
    this.httpServ.sendGetRequest<Permission[]>('/api/user/menu').subscribe(resp => {
      this.permissions = resp;
    })
    this.resizeWindow();
  }

  @HostListener('window:resize', ['$event'])
  resizeWindow() {
    if (window.innerWidth >= 600) {
      this.buttonFlag = false;
    }
    else
      this.buttonFlag = true;
  }

  toggle(){
    this.barFlag = !this.barFlag;
    this.buttonFlag = !this.buttonFlag;
  }

  formatLink(permissionName: string){
    return permissionName.split(' ').join('-');
  }

}
