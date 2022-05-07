import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthentificateComponent } from './Components/authentificate/authentificate.component';
import { CreateaccountComponent } from './Components/createaccount/createaccount.component';
import { HomeComponent } from './Components/home/home.component';
import { EsapaceClientComponent } from './Components/esapace-client/esapace-client.component';
import { EspaceDepartmentManagerComponent } from './Components/espace-department-manager/espace-department-manager.component';
import { EsapaceDeliveryPersonComponent } from './Components/esapace-delivery-person/esapace-delivery-person.component';
import { EsapaceAdministratorComponent } from './Components/esapace-administrator/esapace-administrator.component';
import { AuthorizeGuardService } from './Services/AuthorizeGuard/authorize-guard.service';
import { UserComponent } from './Components/user/user.component';
import { DeliveryAdministratorComponent } from './Components/delivery-administrator/delivery-administrator.component';
import { DepartmentAdministratorComponent } from './Components/department-administrator/department-administrator.component';
import { StockAdministratorComponent } from './Components/stock-administrator/stock-administrator.component';
import { StatisticAdministratorComponent } from './Components/statistic-administrator/statistic-administrator.component';
import { CagnotteAdministratorComponent } from './Components/cagnotte-administrator/cagnotte-administrator.component';
import { EventAdministratorComponent } from './Components/event-administrator/event-administrator.component';
import { HomeClientComponent } from './Components/home-client/home-client.component';
import { ProfileClientComponent } from './Components/profile-client/profile-client.component';
import { CagnotteClientComponent } from './Components/cagnotte-client/cagnotte-client.component';
import { EventClientComponent } from './Components/event-client/event-client.component';
import { DeliveryDeliveryPersonComponent } from './Components/delivery-delivery-person/delivery-delivery-person.component';
import { DepartmentDepartmentManagerComponent } from './Components/department-department-manager/department-department-manager.component';
import { StockDepartmentMangerComponent } from './Components/stock-department-manger/stock-department-manger.component';
import { EventHomeComponent } from './Components/event-home/event-home.component';
import { DepartmentClientComponent } from './Components/espace-department-client/department-client/department-client.component';
import { DeliveryClientComponent } from './Components/delivery-client/delivery-client.component';

import { AuthorizeclientguardService } from './Services/AuthorizeClientGuard/authorizeclientguard.service';
import { AuthorizedepmantguardService } from './Services/AuthorizeDepManagerGuard/authorizedepmantguard.service';
import { AuthorizedeliverymenguardService } from './Services/AuthorizeDeliveryMenGuard/authorizedeliverymenguard.service';
import { ForgotComponent } from './Components/forgot/forgot.component';
import { UpdatepasswordComponent } from './Components/updatepassword/updatepassword.component';





const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'home/event', component: EventHomeComponent },
  { path: 'home/authentificate', component: AuthentificateComponent },
  { path: 'home/createaccount', component: CreateaccountComponent },
  { path: 'home/forgot', component: ForgotComponent },

  { path: 'administrator', component: EsapaceAdministratorComponent },
  { path: 'administrator/user', component: UserComponent },
  { path: 'administrator/delivery', component: DeliveryAdministratorComponent },
  { path: 'administrator/department', component: DepartmentAdministratorComponent},
  { path: 'administrator/stock', component: StockAdministratorComponent},
  { path: 'administrator/statistic', component: StatisticAdministratorComponent},
  { path: 'administrator/cagnotte', component: CagnotteAdministratorComponent },
  { path: 'administrator/event', component: EventAdministratorComponent},


  { path: 'client', component: EsapaceClientComponent},
  { path: 'client/home', component: HomeClientComponent},
  { path: 'client/profile', component: ProfileClientComponent},
  { path: 'client/cagnotte', component: CagnotteClientComponent },
  { path: 'client/event', component: EventClientComponent },
  { path: 'Client/department/virtual_visit', component: DepartmentClientComponent},
  { path: 'client/delivery', component: DeliveryClientComponent},
  { path: 'deliveryperson', component: EsapaceDeliveryPersonComponent },
  { path: 'deliveryperson/delivery', component: DeliveryDeliveryPersonComponent},
  { path: 'products/inmydepartment/:id', component: EspaceDepartmentManagerComponent},

  { path: 'departmentmanager/department', component: DepartmentDepartmentManagerComponent},
  { path: 'departmentmanager/stock', component: StockDepartmentMangerComponent},

  { path: 'home/forgot/updatepassword', component: UpdatepasswordComponent },

  { path: 'orders-and-bills', loadChildren: () => import('./Components/order-bill/order-bill.module').then(m => m.OrderBillModule) },

  { path: '**', component: HomeComponent }

];

@NgModule({
      imports: [RouterModule.forRoot(routes)],
      exports: [RouterModule]
})
export class AppRoutingModule { }
