import {Component, OnInit, EventEmitter, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {FormData} from "../interfaces/formData";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  @Output() submitSignup = new EventEmitter<FormData>();

  public signupGroup = new FormGroup({
    name : new FormControl(''),
    email : new FormControl(''),
    username : new FormControl(''),
    password : new FormControl(''),
  });

  constructor() { }

  ngOnInit(): void {
  }

  onSignup(){
    this.submitSignup.emit({formGroup: this.signupGroup, uri: '/api/account/signup'} as FormData)
  }

}
