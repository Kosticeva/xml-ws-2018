import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service'
import { Router } from '@angular/router'
import { Accomodation } from '../model/accomodation';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [ LoginService ]
})
export class HomeComponent implements OnInit {

	accomodations: Accomodation[];

  constructor(private login : LoginService, private router : Router) { }

	ngOnInit() {
		this.accomodations = [];
		this.login.authenticate(null, () => { /*nakon autentikacije*/ }, () => { /*ako ne uspe da autentfikije*/ });
	}
  
	authenticated() {
		return this.login.authenticated;
	}
	
	
	logout() {
		this.login.logout(() => { this.router.navigateByUrl('/login'); });
	}

}
