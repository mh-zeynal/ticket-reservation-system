import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { SignupComponent } from './signup/signup.component';
import { AccountComponent } from './account/account.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {UserMenuModule} from "./menuModules/user-menu/user-menu.module";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import { TicketReceiptComponent } from './ticket-receipt/ticket-receipt.component';
import { ReservationFormComponent } from './reservation-form/reservation-form.component';
import { SeatPresenterComponent } from './seat-presenter/seat-presenter.component';
import { CustomSeatControlComponent } from './custom-seat-control/custom-seat-control.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    AccountComponent,
    MenuComponent,
    TicketReceiptComponent,
    ReservationFormComponent,
    SeatPresenterComponent,
    CustomSeatControlComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    FormsModule,
    MatButtonModule,
    MatInputModule,
    UserMenuModule
  ],
  providers: [],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
