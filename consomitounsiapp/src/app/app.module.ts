import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { OrderComponent } from './components/order/order.component';
import { AppRoutingModule } from './app-routing.module';
import { OrderService } from './order.service';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BillComponent } from './bill/bill.component';
import {MatSelectModule} from '@angular/material/select';
import { CheckoutComponent } from './checkout/checkout.component';
import { MatDialogModule } from '@angular/material/dialog';
import { BillfilterPipe } from './bill/billfilter.pipe';


@NgModule({
  declarations: [
    AppComponent,
    OrderComponent,
    BillComponent,
    CheckoutComponent,
    BillfilterPipe,
    
  ],
  imports:[
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,MatInputModule, BrowserAnimationsModule,MatSelectModule,
    MatDialogModule,
    
  ],
  providers: [OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
