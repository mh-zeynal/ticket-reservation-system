import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AbstractForm} from "../classes/abstract-form";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent extends AbstractForm implements OnInit {

  constructor() {
    super();
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      username : new FormControl(''),
      password : new FormControl(''),
    })
  }

  onSubmit(){
    this.submitForm.emit(this.form)
  }

}
