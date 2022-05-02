import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/order.service';
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



  constructor(private orderService:OrderService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getAllOrders()
    this.  createOrderGroup()

  }


  
    getAllOrders() {
      this.orderService.getOrder().subscribe((data:any) => {
        let order = data.body;
        console.log(order)
        order.forEach((element:any) => {
          this.tab.push(element)
        });
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
    this.addmode = true;
    this.editMode = false;
    this.tableMode = false;
    this.header = "Add New order";
      }
     


 onSubnit(){
  let order = new Order();
  order.idOrder= this.Form.value.idOrder;
  order.dateOrder= this.Form.value.dateOrder;
  order.productNumberOrder= this.Form.value.productNumberOrder;
  order.stateOrder = this.Form.value.stateOrder;
  order.amountOrder = this.Form.value.amountOrder;
  this.orderService.createOrder( order).subscribe((data: any) => {
      console.log(data);
     
    },
   );

   this.tableMode = true;
   this.editMode = false;
   this.addmode = false;
   window.location.reload();
 
}

onDelete(id:number){
  this.orderService. deleteOrder(id).subscribe((data: any) => {
    console.log(data);
  }, 
 );
 window.location.reload();

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
  this.tableMode = false;
  this.editMode = true;
  this.addmode = false;
this.Form.patchValue(o);
this.order=o;

 
   if( this.order.idOrder !=""){
    this.header = "Edit :" + this.order.idOrder;
  }
    this.header = "Edit the order is not difined";
}

}