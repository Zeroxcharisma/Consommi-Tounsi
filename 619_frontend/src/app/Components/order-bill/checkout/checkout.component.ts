import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AfterViewInit, Component, Inject, OnInit, ViewChild} from '@angular/core';
import {loadStripe, Stripe, StripeCardElementOptions, StripeElementsOptions} from '@stripe/stripe-js';
import {BillService} from "../bill.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {Bill} from "../bill";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StripeCardComponent, StripeService} from "ngx-stripe";


export interface CheckoutData {
  bill: Bill;
}

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit, AfterViewInit {
  @ViewChild(StripeCardComponent) card: StripeCardComponent;

  cardOptions: StripeCardElementOptions = {
    hidePostalCode: true,
    style: {
      base: {
        iconColor: '#666EE8',
        color: '#31325F',
        fontWeight: '300',
        fontFamily: '"Helvetica Neue", Helvetica, sans-serif',
        fontSize: '18px',
        '::placeholder': {
          color: '#CFD7E0'
        }
      }
    }
  };

  elementsOptions: StripeElementsOptions = {
    locale: 'en'
  };

  stripeTest!: FormGroup;

  constructor(
    private fb: FormBuilder, private stripeService: StripeService,
    private http: HttpClient,
    private billService: BillService,
    public dialogRef: MatDialogRef<CheckoutComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CheckoutData,
  ) {
  }

  ngOnInit(): void {
    this.stripeTest = this.fb.group({
      name: ['', [Validators.required]]
    });
  }

  createToken(): void {
    const name = this.stripeTest.get('name').value;
    this.stripeService
      .createToken(this.card.element, { name })
      .subscribe((result) => {
        if (result.token) {
          // Use the token
          console.log(result.token.id);
        } else if (result.error) {
          // Error creating the token
          console.log(result.error.message);
        }
      });
  }

  async ngAfterViewInit() {
    // this.stripe = await loadStripe('pk_test_51KuYmkBFQEhC7HB0qdIrWwKqxwyTzvL1nx12flbe4SH2DcQ7oZcS03dmmSw61nlWXc6IooniggDGxRL5mgy372Ns007uxUtLFA');
    //
    // debugger
    // const elements = this.stripe?.elements();
    // this.card = elements?.create('card');
    // this.card?.mount('#card-element0');
    // this.card.addEventListener('change', () => {
    //   debugger
    //   // var displayError = document.getElementById('card-errors');
    //   // if (event.error) {
    //   //   displayError.textContent = event.error.message;
    //   // } else {
    //   //   displayError.textContent = '';
    //   // }
    // });
  }

  // createToken() {
  //   // this.stripe?.createToken(this.card).then((result) => {
  //   //   if (result.error) {
  //   //     // Inform the user if there was an error
  //   //     // var errorElement = document.getElementById('card-errors');
  //   //     // errorElement.textContent = result.error.message;
  //   //   } else {
  //   //     // Send the token to your server
  //   //     // stripeTokenHandler(result.token);
  //   //     this.billService.checkout(this.data.bill, result.token.id).subscribe(value => {
  //   //
  //   //     })
  //   //   }
  //   // });
  // }
}
