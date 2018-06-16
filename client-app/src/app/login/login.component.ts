import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [ LoginService ]
})
export class LoginComponent implements OnInit {


	credentials = {username: '', password: ''};
	error = false;
  
	constructor(private loginServ : LoginService, private router : Router) { }

	ngOnInit() {
	}
  
	login() {
		this.loginServ.authenticate(
			this.credentials,
			() => {
				this.router.navigateByUrl('/');
			}, 
			() => {
				this.error = true;
			}
		);
	}
  
  logout() {
	this.loginServ.logout(() => {
		this.router.navigateByUrl('/login')
	});
  }

}