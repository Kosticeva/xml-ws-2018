import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AccommodationPageComponent } from './accommodation/accommodation-page.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { MessagesComponent } from './messages/messages.component';
import { ReviewComponent } from './review/review.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
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
    path: 'accommodation/:id',
    component: AccommodationPageComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'messages',
    component: MessagesComponent
  },
  {
    path: 'review/:id',
    component: ReviewComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
