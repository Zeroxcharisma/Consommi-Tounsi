import { Injectable } from '@angular/core';
import { HttpClient ,HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './order';
import { environment } from 'src/environments/environment';

const API_URL = environment.apiBaseUrl;

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  //http://localhost:8083/springmvc/order/getAllOrder
  private baseUrl = API_URL + "/springmvc/order";


  constructor(private http: HttpClient) {}


  getOrder()  {
    return this.http.get<Order[]>(`${this.baseUrl}/getAllOrder`, { observe: 'response' });
  }
 // public getOrder(): Observable<Order[]> {
   // return this.http.get<Order[]>('http://localhost:8083/springmvc/order/getAllOrder');

  //}

  createOrder(order: Order): Observable<HttpResponse<any>> {
    return this.http.post<Order>(`${this.baseUrl}/add-order`, order, { observe: 'response' });
  }


  


  deleteOrder(id: number): Observable<any> {
  //return this.http.delete<void>(`${this.baseUrl}/delete-order/"${id}`);
  return this.http.delete(`${this.baseUrl}/delete-order/${id}`);

  }

  public updateOrder(order: Order): Observable<any> {
    return this.http.put<Order>(`${this.baseUrl}/update-order`, order);
  }
  public findUnlinkedOrders(){
    return this.http.get<Order[]>(`${this.baseUrl}/getUnlinkedOrders`,{ observe: 'response' })
  }
}
