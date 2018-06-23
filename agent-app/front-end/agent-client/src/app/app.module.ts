import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MessageComponent } from './message/message.component';
import { ReservationComponent } from './reservation/reservation.component';
import { ReplyComponent } from './reply/reply.component';
import { AccomodationComponent } from './accomodation/accomodation.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'messages',
    component: MessageComponent
  },
  {
    path: 'reservations',
    component: ReservationComponent
  },
  {
    path: 'reply/:id',
    component: ReplyComponent
  },
  {
    path: 'accomodations',
    component: AccomodationComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    MessageComponent,
    ReservationComponent,
    ReplyComponent,
    AccomodationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
