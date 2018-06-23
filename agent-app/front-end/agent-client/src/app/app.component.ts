import { Component } from '@angular/core';
import { LoginService } from './shared/login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private loginService: LoginService) {
  }

  logout() {
    this.loginService.logout().subscribe();
  }
}
