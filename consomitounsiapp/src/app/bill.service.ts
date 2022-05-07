import { Injectable } from '@angular/core';
import { HttpClient ,HttpResponse} from '@angular/common/http';
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
    return this.http.put<Bill>(`${this.baseUrl}/update-bill`, bill);
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
