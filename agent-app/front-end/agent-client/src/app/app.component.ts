import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from './shared/login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  userLoggedIn: string;

  @Input() status: boolean;

  constructor(private loginService: LoginService) {
    this.userLoggedIn = '';
  }

  ngOnInit(): void {
    this.loginService.checkLoginStatus().subscribe(data => {
      if (data['username'] !== '') {
        this.userLoggedIn = data['username'];
      }
    });
  }

  logout() {
    this.loginService.logout().subscribe(data => {
      this.userLoggedIn = '';
    });

  }

}
