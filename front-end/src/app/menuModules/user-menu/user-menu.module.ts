import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuRootComponent } from './menu-root/menu-root.component';
import { InfoPanelComponent } from './info-panel/info-panel.component';
import {UserMenuRoutingModule} from "./user-menu-routing.module";
import { VipPanelComponent } from './vip-panel/vip-panel.component';
import { TicketPanelComponent } from './ticket-panel/ticket-panel.component';
import {MatButtonModule} from "@angular/material/button";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CustomDateInputComponent} from "./customCntrols/custom-date-input/custom-date-input.component";
import {CustomSearchBoxInputComponent} from "./customCntrols/custom-search-box-input/custom-search-box-input.component";
import { LogoutPanelComponent } from './logout-panel/logout-panel.component';
import { FlightReservationPanelComponent } from './flight-reservation-panel/flight-reservation-panel.component';
import { SearchResultComponent } from './search-result/search-result.component';
import {OverlayModule} from "@angular/cdk/overlay";
import {A11yModule} from "@angular/cdk/a11y";



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
    A11yModule
  ],
  exports: []
})
export class UserMenuModule { }
