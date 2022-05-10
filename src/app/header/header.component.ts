import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { TokenstorageService } from '../../Services/TokenStorage/tokenstorage.service';
import { UserService } from '../../Services/User/user.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: string = localStorage.getItem('AuthUsername');
  NotConnected: boolean = true;
  Client: boolean;
  DeliveryPerson: boolean;
  DepartmentManager: boolean;
  Admin: boolean;
  basket: number
  constructor(private userservice: UserService, private tokenstorage: TokenstorageService, private router: Router ) { }





  ngOnInit(): void {
    if (localStorage.getItem('AuthAuthorities').includes('ADMINISTRATOR')) {
      this.Admin = true;
      this.Client = false;
      this.DeliveryPerson = false;
      this.DepartmentManager = false;
      this.NotConnected = false;
      // tslint:disable-next-line:align
    } if (localStorage.getItem('AuthAuthorities').includes('CLIENT')) {
      this.Client = true;
      this.Admin = false;
      this.DeliveryPerson = false;
      this.DepartmentManager = false;
      this.NotConnected = false;
      // tslint:disable-next-line:align
    } if (localStorage.getItem('AuthAuthorities').includes('DEPARTMENTMANAGER')) {
      this.Client = false;
      this.Admin = false;
      this.DeliveryPerson = false;
      this.DepartmentManager = true;
      this.NotConnected = false;
      // tslint:disable-next-line:align
    } if (localStorage.getItem('AuthAuthorities').includes('DELIVERYPERSON')) {
      this.Client = false;
      this.Admin = false;
      this.DeliveryPerson = true;
      this.DepartmentManager = false;
      this.NotConnected = false;
    } if (localStorage.getItem('AuthAuthorities').includes(null)) {
      this.Client = false;
      this.Admin = false;
      this.DeliveryPerson = false;
      this.DepartmentManager = false;
      this.NotConnected = true;
    }
  }




  // tslint:disable-next-line:typedef
  logOut() {
    localStorage.clear();
  }






  }


