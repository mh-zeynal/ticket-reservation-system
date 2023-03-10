import {Component, OnDestroy, OnInit} from '@angular/core';
import {AccountResponseService} from "../services/account-response.service";
import {ActivatedRoute, Router} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {LoginComponent} from "../login/login.component";
import {ResponseMessage} from "../interfaces/response-message";
import {FormGroup} from "@angular/forms";
import {FormData} from "../interfaces/formData";
import {HttpService} from "../services/http.service";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit, OnDestroy {
  public flag = false;
  private readonly loginStr = 'please login to your account';
  private readonly signupStr = 'please enter your info to make an account';
  public panelDialogue !: string | undefined;
  public errorDialogue = "";


  constructor(public observerSubject: AccountResponseService,
              private route: ActivatedRoute,
              private httpServ: HttpService,
              private router: Router) { }

  ngOnInit(): void {
    if (localStorage.getItem('traUser') != null)
      this.router.navigateByUrl('/userMenu')
    else {
      this.route.queryParams.subscribe(params => {
        this.flag = (params['f'] === "true");
      });
      this.panelDialogue = this.signupStr;
      this.observerSubject.subject.subscribe(msg => {
        // @ts-ignore
        this.errorDialogue = msg;
      })
    }
  }

  switchPanel(value: boolean){
      this.flag = value;
      this.setPanelDialogue(value);
  }

  private setPanelDialogue(value: boolean){
    this.panelDialogue = value ? this.loginStr : this.signupStr;
  }

  public submitForms(data: FormData){
    if (this.isAnyFieldEmpty(data.formGroup)){
      this.errorDialogue = 'please fill all fields';
    }
    else {
      let serialized = data.formGroup.getRawValue();
      // debugger
      this.httpServ.sendPostRequest<ResponseMessage>(data.uri, serialized).subscribe( resp => {
        this.doResponse(resp, data);
      })
    }
  }

  doResponse(resp: any, data: FormData){
    if (!resp.flag)
      this.errorDialogue = resp.description;
    else {
      this.saveData(data.formGroup.controls['username'].value, resp.name);
      this.router.navigateByUrl('/userMenu');
    }
  }

  saveData(username: string, name: string){
    localStorage.setItem("traUser", username);
    localStorage.setItem("traName", name);
    localStorage.setItem("traRole", 'normal');
  }

  isAnyFieldEmpty(form: FormGroup){
    for (const cont in form.controls) {
      if (form.get(cont)?.value == '')
        return true;
    }
    return false;
  }

  ngOnDestroy(): void {
    document.body.style.overflow = '';
  }
}
