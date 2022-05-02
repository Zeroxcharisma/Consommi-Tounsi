import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { OrderComponent } from './components/order/order.component';
import { BillComponent } from './bill/bill.component';



const routes: Routes = [
  {   path: 'order',   component: OrderComponent   },
  {   path: 'bill',   component: BillComponent   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 



}
