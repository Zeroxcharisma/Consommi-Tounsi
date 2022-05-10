import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  public products!: Product[];
  nameprod:any;
  p:number = 1;
  constructor(private productService: ProductService, private router:Router ) {
  }

  ngOnInit(): void {
    this.getProducts();
  }
  private getProducts(){
    this.productService.getListProduct().subscribe(data => {
      this.products= data;
    })
  }
  updateProduct(idprod: any){
    this.router.navigate(['update-product',idprod]);
  }
  deleteProduct(idprod:any){
    this.productService.deleteProduct(idprod).subscribe( data =>{
      console.log(data);
      this.getProducts();
    })
  }


  //   onSearch(dataForm: any) {
  //     this.productService.getProductByName(dataForm).subscribe(data => {
  //        data;
  //     })
  // }
  Search() {
    if (this.nameprod !== '') {
      this.products = this.products.filter((res) => {
        return res.nameprod
          ?.toLocaleLowerCase()
          .match(this.nameprod.toLocaleLowerCase());
      });
    } else if (this.nameprod == '') {
      this.ngOnInit();
    }

  }
   key:string="nameprod";
   reverse:boolean = false;
    sort(key:any) {
    this.key=key;
    this.reverse=!this.reverse;

  }
}
