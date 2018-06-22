import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from '../shared/login/login.service';
import { LoginDTO } from '../shared/login/login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account: LoginDTO;
  response: any;

  constructor(
    private loginService: LoginService
  ) {
    this.account = new LoginDTO("", "");
  }

  ngOnInit() {
    
  }

  login() {
    this.loginService.login(this.account).subscribe(data => {
      this.response = data;
    });
  }

}
