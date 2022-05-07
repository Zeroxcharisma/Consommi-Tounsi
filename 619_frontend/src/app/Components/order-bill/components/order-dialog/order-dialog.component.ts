import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Bill} from "../../bill";
import {Order} from "../../order";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CheckoutData} from "../../checkout/checkout.component";

export interface OrderDialogData {
  order: Order;
}

@Component({
  selector: 'app-order-dialog',
  templateUrl: './order-dialog.component.html',
  styleUrls: ['./order-dialog.component.css']
})
export class OrderDialogComponent implements OnInit {
  Form =  this.fb.group({
    idOrder : this.fb.control(''),
    dateOrder: this.fb.control(''),
    productNumberOrder: this.fb.control(''),
    stateOrder: this.fb.control(''),
    amountOrder: this.fb.control(''),
  })

  get idOrder(){
    return this.Form.get('idOrder');
  }

  constructor( public dialogRef: MatDialogRef<OrderDialogComponent>,
               @Inject(MAT_DIALOG_DATA) public data: OrderDialogData,
               private fb: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.Form.patchValue(this.data.order);
  }

  onSubmit() {
    this.dialogRef.close({order: this.Form.value} as OrderDialogData)
  }
}
