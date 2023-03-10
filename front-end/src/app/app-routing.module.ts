import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AccountComponent} from "./account/account.component";
import {MenuComponent} from "./menu/menu.component";
import {TicketReceiptComponent} from "./ticket-receipt/ticket-receipt.component";
import {ReservationFormComponent} from "./reservation-form/reservation-form.component";

const routes: Routes = [
  {path: 'main', component: MenuComponent},
  {path: 'account', component: AccountComponent},
  {path: 'reserve', component: ReservationFormComponent},
  {path: 'receipt', component: TicketReceiptComponent},
  {path: '', redirectTo: 'main', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
