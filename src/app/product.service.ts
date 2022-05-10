import { Injectable } from '@angular/core';
import {HttpClient, HttpRequest} from '@angular/common/http'
import {Observable} from "rxjs";
import {Product} from "./product";
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseURL = "http://localhost:8083/springmvc/product/products";
  private baseURL1 = "http://localhost:8083/springmvc/product/addproduct";
  private baseURL2 = "http://localhost:8083/springmvc/product/updateProduct";
  private baseURL3 = "http://localhost:8083/springmvc/product/deleteProductById";
  private baseURL4 = "http://localhost:8083/springmvc/product/get-product-ById";
  private baseURL5 = "http://localhost:8083/springmvc/product/getprodbyname";
  private host = "http://localhost:8083/springmvc/product/";

  constructor(private httpClient: HttpClient) {
  }

  getListProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseURL}`);
  }

  createProduct(product: Product): Observable<Object> {
    return this.httpClient.post(`${this.baseURL1}`, product);
  }

  updateProduct(idprod: any, product: Product): Observable<Object> {
    return this.httpClient.put(`${this.baseURL2}/${idprod}`, product);
  }

  deleteProduct(idprod: any): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL3}/${idprod}`);
  }

  getProductById(idprod: any): Observable<Product> {
    return this.httpClient.get<Product>(`${this.baseURL4}/${idprod}`);
  }

  getProductByName(nameprod: any): Observable<Product> {
    return this.httpClient.get<Product>(`${this.baseURL5}/${nameprod}`);
  }


  // @ts-ignore
  uploadPhotoProduct(file: File, idProduct:any): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();
    formdata.append('file', file);
    const req = new HttpRequest('POST', this.host + '/uploadPhoto/' + idProduct, formdata, {
      reportProgress: true,
      responseType: 'text'
    });
  }
}
