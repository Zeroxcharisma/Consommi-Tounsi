import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit(): void {



  }

  async chargeCreditCard() {
    let form = document.getElementsByTagName("form")[0];
    const amina =await(<any>window).Stripe.card.createToken({
      number: form['cardNumber'].value,
      exp_month: form['expMonth'].value,
      exp_year: form['expYear'].value,
      cvc: form['cvc'].value
    
    });
    debugger
  }
  chargeCard(token: string) {
    const headers = new HttpHeaders({'stripe-token': token});
    this.http.post('http://localhost:8080/checkout/1', {}, {headers: headers})
      .subscribe(resp => {
        console.log(resp);
      })
  }

}
