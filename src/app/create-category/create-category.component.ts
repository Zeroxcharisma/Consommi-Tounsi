import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";
import {Router} from "@angular/router";
import {Category} from "../category";
import {CategoryService} from "../category.service";

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {

  category: Category=new Category();
  constructor(private CategoryService: CategoryService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.category);
    this.saveCategory();
  }

  private saveCategory() {
    this.CategoryService.createCategory(this.category).subscribe(data => {
        console.log(data);
        this.goToCategoryList();
      },
      error => console.log(error));
  }

  private goToCategoryList() {
    this.router.navigate(['/categories']);
  }


}
