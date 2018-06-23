import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from '../shared/login/login.service';
import { LoginDTO } from '../shared/login/login.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Output() loginStatus: EventEmitter<any> = new EventEmitter();

  account: LoginDTO;
  response: any;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {
    this.account = new LoginDTO("", "");
  }

  ngOnInit() {

  }

  refresh(): void {
    window.location.reload();
  }

  login() {
    console.log(this.account.username);
    console.log(this.account.password);
    this.loginService.login(this.account).subscribe(data => {
      this.response = data;
      this.loginStatus.emit(true);
      this.router.navigate(['/home']);
      this.refresh();
    });
  }

}
