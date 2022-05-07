import { BrowserModule } from '@angular/platform-browser';
import { InjectionToken, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, NgForm, NgModel, ReactiveFormsModule } from '@angular/forms';
import {HttpClient, HttpClientModule, HttpClientXsrfModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { HomeComponent } from './Components/home/home.component';
import { SliderComponent } from './Components/slider/slider.component';
import { AuthentificateComponent } from './Components/authentificate/authentificate.component';
import { CreateaccountComponent } from './Components/createaccount/createaccount.component';
import { StockComponent } from './Components/stock/stock.component';
import { UserComponent } from './Components/user/user.component';
import { EsapaceClientComponent } from './Components/esapace-client/esapace-client.component';
import { EspaceDepartmentManagerComponent } from './Components/espace-department-manager/espace-department-manager.component';
import { EsapaceDeliveryPersonComponent } from './Components/esapace-delivery-person/esapace-delivery-person.component';
import { EsapaceAdministratorComponent } from './Components/esapace-administrator/esapace-administrator.component';
import { AuthInterceptorService } from './Services/AuthInterceptor/auth-interceptor.service';
import { LogoutComponent } from './Components/logout/logout.component';
import { MyprofileclientComponent } from './Components/myprofileclient/myprofileclient.component';
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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxStripeModule } from 'ngx-stripe';
import { ToastrModule } from 'ngx-toastr';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SecondNavComponent } from './Components/second-nav/second-nav.component';
import { DeliveryClientComponent } from './Components/delivery-client/delivery-client.component';
import { ForgotComponent } from './Components/forgot/forgot.component';
import { UpdatepasswordComponent } from './Components/updatepassword/updatepassword.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { NgxCaptchaModule } from 'ngx-captcha';
import { MatInputModule } from '@angular/material/input';






@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    SliderComponent,
    AuthentificateComponent,
    CreateaccountComponent,
    StockComponent,
    UserComponent,
    EsapaceClientComponent,
    EspaceDepartmentManagerComponent,
    EsapaceDeliveryPersonComponent,
    EsapaceAdministratorComponent,
    LogoutComponent,
    MyprofileclientComponent,
    DeliveryAdministratorComponent,
    DepartmentAdministratorComponent,
    StockAdministratorComponent,
    StatisticAdministratorComponent,
    CagnotteAdministratorComponent,
    EventAdministratorComponent,
    HomeClientComponent,
    ProfileClientComponent,
    CagnotteClientComponent,
    EventClientComponent,
    DeliveryDeliveryPersonComponent,
    DepartmentDepartmentManagerComponent,
    StockDepartmentMangerComponent,
    EventHomeComponent,
    DepartmentClientComponent,
    SecondNavComponent,
    DeliveryClientComponent,
    ForgotComponent,
    UpdatepasswordComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    NgxCaptchaModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgbModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgxStripeModule.forRoot('pk_test_51IziEXDGIe2QH5KPbwRWzkIgPxzHWJ21nzT9LMZdb01c5xNMDu8B1Vww6Z5Y60HVIfJPhdUU9D3J1VLN06mnBYvS00HUQItxxq'),
    TranslateModule.forRoot({
      defaultLanguage: 'en',
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]

      }
    }

    )


  ],
  entryComponents: [],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true },
   // { provide: JWT_OPTIONS, useValue: JWT_OPTIONS }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

// tslint:disable-next-line:typedef
export function createTranslateLoader(http: HttpClient){
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');

}
