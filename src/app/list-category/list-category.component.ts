import { Component, OnInit } from '@angular/core';
import {Category} from "../category";
import {Router} from "@angular/router";
import {CategoryService} from "../category.service";

@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.css']
})
export class ListCategoryComponent implements OnInit {

  public categories!: Category[];
  constructor(private categoryService: CategoryService, private router:Router) { }

  ngOnInit(): void {this.getProducts();
  }
  private getProducts(){
    this.categoryService.getListCategory().subscribe(data => {
      this.categories= data;
    })
  }

}
