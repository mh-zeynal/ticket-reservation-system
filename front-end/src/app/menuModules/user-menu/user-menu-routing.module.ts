import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {InfoPanelComponent} from "./info-panel/info-panel.component";
import {MenuRootComponent} from "./menu-root/menu-root.component";
import {VipPanelComponent} from "./vip-panel/vip-panel.component";
import {TicketPanelComponent} from "./ticket-panel/ticket-panel.component";
import {LogoutPanelComponent} from "./logout-panel/logout-panel.component";
import {FlightReservationPanelComponent} from "./flight-reservation-panel/flight-reservation-panel.component";
import {AuthGuard} from "../../auth.guard";


const routes: Routes = [
  {path: 'userMenu', component: MenuRootComponent,
    children: [
      {path: 'see-info', component: InfoPanelComponent},
      {path: 'logout', component: LogoutPanelComponent},
      {path: 'buy-ticket', component: TicketPanelComponent},
      {path: 'upgrade-to-vip', component: VipPanelComponent},
      {path: 'flights', component: FlightReservationPanelComponent}
    ], canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserMenuRoutingModule { }
