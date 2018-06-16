import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { NavigationComponent } from './navigation/navigation.component';
import {RouterModule} from "@angular/router";
import { AgentRegistrationComponent } from './agent-registration/agent-registration.component';
import { UsersComponent } from './users/users.component';
import {UsersService} from "./users/users.service";
import {AgentService} from "./agent-registration/agent.service";
import { ReviewsComponent } from './reviews/reviews.component';
import {ReviewService} from "./reviews/review.service";
import { AccomodationComponent } from './accomodation/accomodation.component';
import {AccomService} from "./accomodation/accom.service";
import { AddTypeComponent } from './accomodation/add-type/add-type.component';
import { AddServiceComponent } from './accomodation/add-service/add-service.component';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    HttpClientModule,
    FormsModule,
    RouterModule
  ],
  declarations: [LoginComponent, HomeComponent, NavigationComponent, AgentRegistrationComponent, UsersComponent, ReviewsComponent, AccomodationComponent, AddTypeComponent, AddServiceComponent],
  providers: [LoginService, UsersService, AgentService, ReviewService, AccomService]
})
export class MainModule { }
