import {Component, OnInit, EventEmitter, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {FormData} from "../interfaces/formData";
import {AbstractForm} from "../classes/abstract-form";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent extends AbstractForm implements OnInit {

  constructor() {
    super();
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      name : new FormControl(''),
      email : new FormControl(''),
      username : new FormControl(''),
      password : new FormControl(''),
    });
  }


  onSubmit(): void {
    this.submitForm.emit(this.form);
  }

}
