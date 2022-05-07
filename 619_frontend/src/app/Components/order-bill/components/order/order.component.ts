import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import {Order} from "../../order";
import {OrderService} from "../../order.service";
import {MatDialog} from "@angular/material/dialog";
import {Bill} from "../../bill";
import {CheckoutComponent} from "../../checkout/checkout.component";
import {OrderDialogComponent, OrderDialogData} from "../order-dialog/order-dialog.component";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

 Form = new FormGroup({});
 order: Order = new Order();
 tab:any []=[] ;
 header:string=""


 tableMode = true;
 editMode = false;
 addmode = false;
 Error: Order  = {
    idOrder: 0,
    dateOrder:new Date,
    productNumberOrder:0,
    stateOrder: "",
    amountOrder: 0,
  };

  constructor(
    private orderService:OrderService,
    private fb: FormBuilder,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getAllOrders();
    this.createOrderGroup();
  }

  getAllOrders() {
      this.orderService.getOrder().subscribe((data:any) => {
        let orders = data.body;
        this.tab = orders;
      })
}


  //create the order form group
  createOrderGroup(){
    this.Form =  this.fb.group({
      idOrder : this.fb.control(this.order.idOrder),
      dateOrder: this.fb.control(this.order.dateOrder),
      productNumberOrder: this.fb.control(this.order.productNumberOrder),
      stateOrder: this.fb.control(this.order.stateOrder),
      amountOrder: this.fb.control(this.order.amountOrder),
    });
  }


  onAdd(){
    // this.addmode = true;
    // this.editMode = false;
    // this.tableMode = false;
    // this.header = "Add New order";
    this.openDialog();
 }



 onSubmit(order: Order){
  this.orderService.createOrder(order).subscribe((data: any) => {
    console.log(data);
    // this.tableMode = true;
    // this.editMode = false;
    // this.addmode = false;
    this.getAllOrders();
    },
   );

}

onDelete(id:number){
  this.orderService.deleteOrder(id).subscribe((data: any) => {
    console.log(data);
    this.getAllOrders();
  },
 );
}

 onUpdateOrder(order: Order): void {
  this.orderService.updateOrder(order).subscribe(
    (response: Order) => {
      console.log(response);
      this.getAllOrders();
    },
  );
}


getuser(  id:number ):Order {
  const userToFind=this.tab.find(e=> e.idOrder===id);
   if(userToFind)
  return userToFind;
  return this.Error;
}


onUpdate(o:Order){
  // this.tableMode = false;
  // this.editMode = true;
  // this.addmode = false;
  this.Form.patchValue(o);
  this.order=o;

  this.openDialog(o);

  //  if( this.order.idOrder !=""){
  //   this.header = "Edit :" + this.order.idOrder;
  // }
  //   this.header = "Edit the order is not difined";
}

  openDialog(order?: Order): void {
    const dialogRef = this.dialog.open(OrderDialogComponent, {
      width: '500px',
      data: {order},
    });

    dialogRef.afterClosed().subscribe((result:OrderDialogData) => {
      if (order){
        this.onUpdateOrder(result.order);
        return;
      }
      this.onSubmit(result.order);
    });
  }

}
