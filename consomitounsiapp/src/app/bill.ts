import { Order } from "./order";
import {PaymentType} from "./paymentType";
export class Bill {
    idBill?: any;
    montant?:any;
    dateBill:any;
    
    paymentType?: any;
    order?:Order;
   
  }


 