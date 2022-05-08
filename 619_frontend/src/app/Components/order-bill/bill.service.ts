import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bill } from './bill';
import { environment } from 'src/environments/environment';

const API_URL = environment.apiBaseUrl;

@Injectable({
  providedIn: 'root'
})
export class BillService {



  private baseUrl = API_URL + "/springmvc/bill";


  constructor(private http: HttpClient) {}


  getBill(): Observable<HttpResponse<any>> {
    return this.http.get<Bill[]>(`${this.baseUrl}/getAllBill`, { observe: 'response' });
  }
 // public getOrder(): Observable<Order[]> {
   // return this.http.get<Order[]>('http://localhost:8083/springmvc/order/getAllOrder');

  //}

  createBill(bill:Bill ): Observable<HttpResponse<any>> {
    return this.http.post<Bill>(`${this.baseUrl}/add-bill`, bill, { observe: 'response' });
  }


  updateBill( bill: Bill): Observable<Object> {
    return this.http.put<Bill>(`${this.baseUrl}/modify-bill`, bill);
  }


  checkout( bill: Bill, stripeToken:string): Observable<Object> {
    // let headers = new HttpHeaders();
    // headers = headers.set('stripe-token', stripeToken);
    return this.http.post(`${this.baseUrl}/checkout/${bill.idBill}/${stripeToken}`, null,{  observe: 'response'});
  }


  deleteBill(id: number): Observable<any> {
    //return this.http.delete<void>(`${this.baseUrl}/delete-order/"${id}`);
    return this.http.delete(`${this.baseUrl}/delete-bill/${id}`);
  }

  getPDF(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/pdf/${id}`, {
      responseType: 'blob'
    });
  }

}
