import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuRootComponent } from './menu-root/menu-root.component';
import { InfoPanelComponent } from './info-panel/info-panel.component';
import {UserMenuRoutingModule} from "./user-menu-routing.module";
import { VipPanelComponent } from './vip-panel/vip-panel.component';
import { TicketPanelComponent } from './ticket-panel/ticket-panel.component';
import {CustomDateInputComponent} from "./customCntrols/custom-date-input/custom-date-input.component";
import {CustomSearchBoxInputComponent} from "./customCntrols/custom-search-box-input/custom-search-box-input.component";
import { FlightReservationPanelComponent } from './flight-reservation-panel/flight-reservation-panel.component';
import { SearchResultComponent } from './search-result/search-result.component';
import { LogoutPanelComponent } from './logout-panel/logout-panel.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxMatSelectSearchModule} from "ngx-mat-select-search";
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {PlatformModule} from '@angular/cdk/platform';
import {OverlayModule} from "@angular/cdk/overlay";
import {A11yModule} from "@angular/cdk/a11y";
import {RouterModule} from "@angular/router";
import {MatNativeDateModule} from "@angular/material/core";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";



@NgModule({
  declarations: [
    MenuRootComponent,
    InfoPanelComponent,
    VipPanelComponent,
    TicketPanelComponent,
    CustomDateInputComponent,
    CustomSearchBoxInputComponent,
    LogoutPanelComponent,
    FlightReservationPanelComponent,
    SearchResultComponent
  ],
  imports: [
    CommonModule,
    UserMenuRoutingModule,
    MatButtonModule,
    ReactiveFormsModule,
    FormsModule,
    OverlayModule,
    A11yModule,
    RouterModule,
    MatSidenavModule,
    PlatformModule,
    MatSelectModule,
    NgxMatSelectSearchModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
  ],
  exports: []
})
export class UserMenuModule { }
