import { Component, OnInit } from '@angular/core';
import { RegisterService } from './register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [ RegisterService ]
})
export class RegisterComponent implements OnInit {
	
	error = false;
	missingFieldError = false;

	user = {
		username : '',
		password : '',
		firstName : '',
		lastName :  '',
		email : '',
	};
	passwordRepeat = '';

	constructor(private registerSrvc : RegisterService, private router : Router) { }

	ngOnInit() {
	}

	register() {
	
		if (this.user.username == '' || 
			this.user.password == '' || 
			this.user.firstName == '' || 
			this.user.lastName == '' || 
			this.user.email == '' || 
			this.passwordRepeat == ''
			) {
			this.missingFieldError = true;
			return;
		}
		
		this.registerSrvc.register(
			this.user,
			() => {
				this.router.navigateByUrl('/login');
			}, 
			() => {
				this.error = true;
			}
		)
	}
  
}
