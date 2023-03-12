import {Component, OnInit} from '@angular/core';
import {HttpService} from "../services/http.service";
import {FormGroup} from "@angular/forms";
import {ResponseMessage} from "../interfaces/response-message";
import {FormData} from "../interfaces/formData";
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
})
export class MenuComponent implements OnInit {
  accountFormType = 'signup';

  constructor(private http: HttpService, private router: Router) { }

  ngOnInit(): void { }

  onFormSubmit(url: string, form: FormGroup) {
    this.http.sendPostRequest<ResponseMessage>(url, form.getRawValue()).subscribe( resp => {
      this.doResponse(resp, form);
    })
  }

  doResponse(resp: any, form: FormGroup){
    if (!resp.flag)
      return;
    this.saveData(form.controls['username'].value, resp.name);
    this.router.navigateByUrl('/userMenu');
  }

  saveData(username: string, name: string){
    localStorage.setItem("traUser", username);
    localStorage.setItem("traName", name);
    localStorage.setItem("traRole", 'normal');
  }


}
