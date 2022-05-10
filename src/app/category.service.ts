import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "./product";
import {Category} from "./category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseURL = "http://localhost:8083/springmvc/product/getAllCategories";
  private baseURL1 = "http://localhost:8083/springmvc/product/addCategory";

  constructor(private httpClient: HttpClient) { }

  getListCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(`${this.baseURL}`);
  }

  createCategory(category: Category): Observable<Object> {
    return this.httpClient.post(`${this.baseURL1}`, category);
  }
}
