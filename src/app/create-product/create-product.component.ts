import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";
import {Router} from "@angular/router";
import {HttpEventType, HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product: Product = new Product();

  currentProduct:any;
  selectedFiles:any;
  progress: number =0;
  currentFileUpload: any;
  private currentTime : number=0;
  private editPhoto : boolean = true;
  private mode: number = 0;

  constructor(private productService: ProductService, private router: Router) {
  }

  ngOnInit(): void {
  }

  saveProduct() {
    this.productService.createProduct(this.product).subscribe(data => {
        console.log(data);
        this.goToProductList();
      },
      error => console.log(error));
  }

  goToProductList() {
    this.router.navigate(['/products']);
  }

  onSubmit() {
    console.log(this.product);
    this.saveProduct();
  }

  updatephoto() {
    this.progress = 0;
    this.currentFileUpload = this.selectedFiles.item(0)
    this.productService.uploadPhotoProduct(this.currentFileUpload, this.currentProduct.id).subscribe((event: { type: HttpEventType; loaded: number; total: number; }) => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        //console.log(this.router.url);
        //this.getProducts(this.currentRequest);
        //this.refreshUpdatedProduct();
        this.currentTime = Date.now();
        this.editPhoto = false;
      }
    })

  }
}
