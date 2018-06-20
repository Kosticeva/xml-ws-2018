import { Component } from '@angular/core';
import { QueryShareService } from './services/queryshare.service'
import { LoginService } from './login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ QueryShareService, LoginService ]
})
export class AppComponent {
  title = 'app';

  constructor(
    private login : LoginService,
    private router : Router
  ){
		this.login.authenticate(null, () => { /*nakon autentikacije*/ }, () => { /*ako ne uspe da autentfikije*/ });
  }

  authenticated() {
		return this.login.authenticated;
	}
	
	logout() {
		this.login.logout(() => { this.router.navigateByUrl('/login'); });
	}
}
