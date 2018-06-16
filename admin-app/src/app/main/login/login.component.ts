import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { User } from '../model/user';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(user: User) {
    this.loginService.login(user).subscribe(
      (data) => {
        this.loginService.setUser(data);
        this.router.navigateByUrl('home');

      }
    );
  }
}
