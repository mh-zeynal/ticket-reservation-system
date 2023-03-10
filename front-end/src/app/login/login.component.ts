import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpService} from "../services/http.service";
import {ResponseMessage} from "../interfaces/response-message";
import {AccountResponseService} from "../services/account-response.service";
import {Router} from "@angular/router";
import {FormData} from "../interfaces/formData";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @Output() submitLogin = new EventEmitter<FormData>();

  public loginGroup = new FormGroup({
    username : new FormControl(''),
    password : new FormControl(''),
  })

  constructor() { }

  ngOnInit(): void {
  }

  onLogin(){
    this.submitLogin.emit({formGroup: this.loginGroup, uri: '/api/account/login'} as FormData)
  }

}
