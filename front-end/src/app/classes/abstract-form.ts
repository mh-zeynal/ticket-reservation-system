import {FormGroup} from "@angular/forms";
import {Directive, EventEmitter, Output} from "@angular/core";

@Directive()
export abstract class AbstractForm {

  form!: FormGroup;
  @Output() submitForm = new EventEmitter<FormGroup>();
  @Output() formType = new EventEmitter<string>();

  public abstract onSubmit(): void;
}
