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

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AccomodationsComponent } from './accomodations/accomodations.component';
import { CreateReservationComponent } from './create-reservation/create-reservation.component';

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
    path: 'create-reservation',
    component: CreateReservationComponent
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
    path: 'accomodation',
    component: AccomodationComponent
  },
  {
    path: 'accomodations',
    component: AccomodationsComponent
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
    AccomodationComponent,
    AccomodationsComponent,
    CreateReservationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
