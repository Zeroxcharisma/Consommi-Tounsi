import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Order} from "../../order";
import {OrderService} from "../../order.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {OrderDialogData} from "../../components/order-dialog/order-dialog.component";
import {Bill} from "../../bill";


export interface BillDialogData {
  bill: Bill;
}


@Component({
  selector: 'app-bill-dialog',
  templateUrl: './bill-dialog.component.html',
  styleUrls: ['./bill-dialog.component.css']
})
export class BillDialogComponent implements OnInit {

  Form = this.fb.group({
    idBill : this.fb.control(''),
    montant: this.fb.control(''),
    dateBill: this.fb.control(''),
    paymentType: this.fb.control(''),
    order: this.fb.control(''),
  });

  get idBill(){
    return this.Form.get('idBill');
  }

  orders:Order[] = [];

  constructor(
    private fb: FormBuilder,
    private orderService:OrderService,
    public dialogRef: MatDialogRef<BillDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: BillDialogData,
  ) { }

  ngOnInit(): void {
    this.orderService.findUnlinkedOrders().subscribe((orders)=>{
      this.orders=orders.body || [];
      console.log( this.orders)
    })
    if (this.data){
      this.Form.patchValue(this.data.bill);
    }
  }

  onSubmit() {
    this.dialogRef.close({bill: this.Form.value} as BillDialogData);
  }
}
