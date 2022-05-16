import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { BarcodeResponse } from 'src/app/Models/BarcodeResponse';
import { Product } from '../../Models/Product';
const cabecera = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public dataForm: FormGroup;

  productsURL = "http://localhost:9091/SpringMVC/servlet/show-all-products";
  deleteProdUrl = "http://localhost:9091/SpringMVC/servlet/remove-product/";
  addProdUrl = "http://localhost:9091/SpringMVC/servlet/add-product";
  putProdUrl = "http://localhost:9091/SpringMVC/servlet/update-Product/";
  PostProdcutUrl = "http://localhost:9091/SpringMVC/servlet/Productss";
  deleteAvance = "http://localhost:9091/SpringMVC/servlet/products";
  productURL = 'http://localhost:9091/SpringMVC/servlet/';
  //addProdToBasketUrl = "http://localhost:9091/SpringMVC/servlet/AffectProdToBasket/";
  likeProductUrl="http://localhost:9091/SpringMVC/servlet/like-product";



  constructor(private prodhttp: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.prodhttp.get<Product[]>(this.productsURL);
  }


  deleteProductById(id: number) {
    return this.prodhttp.delete(this.deleteProdUrl + id);
  }


  addProduct(product: Product, id: number, idd: number) {//produit+underc+dep
    return this.prodhttp.post(`${this.addProdUrl}/${id}/${idd}`, product, {});
  }


  updateproduct(id: number, product: Product) {
    return this.prodhttp.put(this.putProdUrl + id, product);
  }

//pour faire un form
  createData(formData: FormData): Observable<any> {
    return this.prodhttp.post(`${this.PostProdcutUrl}`, formData);
  }


  deleteData(id: number): Observable<any> {

    return this.prodhttp.delete(`${this.deleteAvance}/${id}`, { responseType: 'text' });
  }






















  public lista(): Observable<Product[]> {
    return this.prodhttp.get<Product[]>('http://localhost:9091/SpringMVC/servlet/lista', cabecera);
  }

  public detalle(idProduct: number): Observable<Product> {
    return this.prodhttp.get<Product>(this.productURL + `detalle/${idProduct}`, cabecera);
  }

  likeProduct(p:Product,id:number){
     this.prodhttp.post(this.likeProductUrl+id,p);
   }

}
