import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderComponent } from './components/order/order.component';
import { BillComponent } from './bill/bill.component';
import {OrderBillLandingPage} from "./order-bill-landing-page.component";



const routes: Routes = [
  {
    path: '',
    component: OrderBillLandingPage,
    children: [
      {   path: '',  redirectTo: 'order' },
      {   path: 'order',   component: OrderComponent },
      {   path: 'bill',   component: BillComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderBillRoutingModule {



}
