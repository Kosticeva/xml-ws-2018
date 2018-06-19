import { Component } from '@angular/core';
import { QueryShareService } from './services/queryshare.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ QueryShareService ]
})
export class AppComponent {
  title = 'app';
}
