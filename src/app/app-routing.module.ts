import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListProductComponent} from "./list-product/list-product.component";
import {CreateProductComponent} from "./create-product/create-product.component";
import {UpdateProductComponent} from "./update-product/update-product.component";
import {ListCategoryComponent} from "./list-category/list-category.component";
import {CreateCategoryComponent} from "./create-category/create-category.component";

const routes: Routes = [
  {path: 'products', component:ListProductComponent},
  {path: 'create-product',component:CreateProductComponent},
  {path: '', redirectTo: 'products', pathMatch:'full'},
  {path: 'update-product/:idprod', component:UpdateProductComponent},
  {path: 'categories', component:ListCategoryComponent},
  {path: 'create-category',component:CreateCategoryComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
