import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  product: Product=new Product();
  idprod:any;
  constructor(private productService:ProductService, private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idprod= this.route.snapshot.params['idprod'];

  }

  onSubmit() {
    this.productService.updateProduct(this.idprod,this.product).subscribe( data =>{
      this.goToProductList();
    },
      error => console.log(error));

  }
  goToProductList()
  {
    this.router.navigate(['/products']);
  }
}
