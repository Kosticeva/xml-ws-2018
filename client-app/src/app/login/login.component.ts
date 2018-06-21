import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


	credentials = {username: '', password: ''};
	error = false;
  
	constructor(
		private loginServ : LoginService,
		private router : Router,
		private route: ActivatedRoute
		) { }

	ngOnInit() {
	}
  
	login() {
		this.loginServ.authenticate(
			this.credentials,
			() => {
				this.loginServ.authenticate(null, () => { /*nakon autentikacije*/ }, () => { /*ako ne uspe da autentfikije*/ });
				if (this.route.snapshot.queryParamMap.get('refback') != "")
					this.router.navigateByUrl(this.route.snapshot.queryParamMap.get('refback'));
				else
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