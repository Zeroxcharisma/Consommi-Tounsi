import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Bill } from '../bill';
import { Order } from '../order';

import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { CheckoutComponent } from '../checkout/checkout.component';
import {MatDialogModule} from '@angular/material/dialog';
import { saveAs } from 'file-saver';
import {BillService} from "../bill.service";
import {OrderService} from "../order.service";
import {OrderDialogComponent, OrderDialogData} from "../components/order-dialog/order-dialog.component";
import {BillDialogComponent, BillDialogData} from "./bill-dialog/bill-dialog.component";

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

 Form = new FormGroup({});
 bill: Bill = new Bill();
 tab:any[] = [];
 header:string="";
 orders:Order[] = [];

 // tableMode = true;
 // editMode = false;
 // addmode = false;

  constructor(private billService:BillService,
    private fb: FormBuilder,
    private orderService:OrderService,
    public dialog: MatDialog,) { }

  ngOnInit(): void {
    this.getAllBills()
    this.  createBillGroup()
    this.orderService.findUnlinkedOrders().subscribe((orders)=>{
   this.orders=orders.body||[];
   console.log( this.orders)
    })
  }

  getAllBills() {
      this.billService.getBill().subscribe((data:any) => {
        let bill = data.body;
        this.tab = bill;
      })
}

  //create the order form group
  createBillGroup(){
    this.Form =  this.fb.group({
      idBill : this.fb.control(this.bill.idBill),
      montant: this.fb.control(this.bill.montant),
      dateBill: this.fb.control(this.bill. dateBill),
      paymentType: this.fb.control(this.bill. paymentType),
      order: this.fb.control(this.bill. order),
      //idBill: this.fb.control(this.bill.idBill),
    });
  }


  onAdd(){
    // this.addmode = true;
    // this.editMode = false;
    // this.tableMode = false;
    // this.header = "Add New bill";
    this.openDialog();
      }



 onSubmit(bill: Bill){
   // const bill = this.Form.value;
   delete bill.idBill;
   this.billService.createBill(bill).subscribe((data: any) => {
      console.log(data);
      this.getAllBills();
    // this.tableMode = true;
    // this.editMode = false;
    // this.addmode = false;
    },
   );



}

onDelete(id:number){
  this.billService. deleteBill(id).subscribe((data: any) => {
    console.log(data);
  },
 );
}




onupdateBill(bill: Bill): void {
  // this.tableMode = false;
  // this.editMode = true;
  // this.addmode = false;
this.Form.patchValue(bill);
this.bill=bill;
this.openDialog(bill);


  //  if( this.bill.idBill !=""){
  //   this.header = "Edit :" + this.bill.idBill ;
  // }
  //   this.header = "Edit the bill is not difined";

  }

  openDialog(bill?: Bill): void {
    const dialogRef = this.dialog.open(BillDialogComponent, {
      width: '500px',
      data: {bill},
    });

    dialogRef.afterClosed().subscribe((result:BillDialogData) => {
     if (result?.bill){
       if (bill){
         this.billService.updateBill(result.bill).subscribe(() => this.getAllBills())
         return;
       }
       this.onSubmit(result.bill);
     }
    });
  }

openCheckoutDialog(bill: Bill): void {
  const dialogRef = this.dialog.open(CheckoutComponent, {
    width: '500px',
    data: {bill},
  });

  dialogRef.afterClosed().subscribe(result => {

  });
}


  export(idBill: any) {
    this.billService.getPDF(idBill).subscribe(blob => saveAs(blob, `${idBill}.pdf`))
  }
}
