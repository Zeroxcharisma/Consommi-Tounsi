import { HttpClient, HttpHeaders } from '@angular/common/http';
import {AfterViewInit, Component, Inject, OnInit} from '@angular/core';
import {loadStripe, Stripe} from '@stripe/stripe-js';
import {BillService} from "../bill.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {Bill} from "../bill";


export interface CheckoutData {
  bill: Bill;
}

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit, AfterViewInit {
  private stripe: Stripe | null = null;
  private card: any = null;

  constructor(private http:HttpClient,
              private billService: BillService,
              public dialogRef: MatDialogRef<CheckoutComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CheckoutData,
  ) {}

  ngOnInit(): void {
  }

  async ngAfterViewInit() {
    this.stripe = await loadStripe('pk_test_51KuYmkBFQEhC7HB0qdIrWwKqxwyTzvL1nx12flbe4SH2DcQ7oZcS03dmmSw61nlWXc6IooniggDGxRL5mgy372Ns007uxUtLFA');
    const elements = this.stripe?.elements();
    this.card = elements?.create('card');
    this.card?.mount('#card-element0');
    this.card.addEventListener('change',()=>{
      debugger
      // var displayError = document.getElementById('card-errors');
      // if (event.error) {
      //   displayError.textContent = event.error.message;
      // } else {
      //   displayError.textContent = '';
      // }
    });
  }

  createToken() {
    this.stripe?.createToken(this.card).then((result)=>{
      if (result.error) {
        // Inform the user if there was an error
        // var errorElement = document.getElementById('card-errors');
        // errorElement.textContent = result.error.message;
      } else {
        debugger
        // Send the token to your server
        // stripeTokenHandler(result.token);
        this.billService.checkout(this.data.bill, result.token.id).subscribe(value => {
          debugger
        })
      }
    });
  }
}
