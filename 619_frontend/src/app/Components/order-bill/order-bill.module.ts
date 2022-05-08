import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BillComponent} from "./bill/bill.component";
import {OrderComponent} from "./components/order/order.component";
import {BillfilterPipe} from "./bill/billfilter.pipe";
import {CheckoutComponent} from "./checkout/checkout.component";
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatDialogModule} from "@angular/material/dialog";
import {OrderService} from "./order.service";
import {MatSelectModule} from "@angular/material/select";
import {OrderBillLandingPage} from "./order-bill-landing-page.component";
import {OrderBillRoutingModule} from "./order-bill-routing.module";
import {MatMenuModule} from "@angular/material/menu";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import { OrderDialogComponent } from './components/order-dialog/order-dialog.component';
import { BillDialogComponent } from './bill/bill-dialog/bill-dialog.component';


@NgModule({
  declarations: [
    OrderComponent,
    BillComponent,
    CheckoutComponent,
    BillfilterPipe,
    OrderBillLandingPage,
    OrderDialogComponent,
    BillDialogComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule,
    MatDialogModule,
    OrderBillRoutingModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
  ],
  providers: [OrderService],
})
export class OrderBillModule { }
