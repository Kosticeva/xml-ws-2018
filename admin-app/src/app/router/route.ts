import {LoginComponent} from "../main/login/login.component";
import {Routes, RouterModule} from "@angular/router";
import {HomeComponent} from "../main/home/home.component";
import {AgentRegistrationComponent} from "../main/agent-registration/agent-registration.component";
import {UsersComponent} from "../main/users/users.component";
import {ReviewsComponent} from "../main/reviews/reviews.component";
import {AccomodationComponent} from "../main/accomodation/accomodation.component";
import {AddServiceComponent} from "../main/accomodation/add-service/add-service.component";
import {AddTypeComponent} from "../main/accomodation/add-type/add-type.component";
import { AddCategoryComponent } from "../main/accomodation/add-category/add-category.component";

const APP_ROUTES: Routes=[
  {path:'', component: LoginComponent},
  {path: 'home', component: HomeComponent,
    children:[
      {path:'',component: UsersComponent},
      {path:'register-agent',component: AgentRegistrationComponent},
      {path:'reviews',component: ReviewsComponent},
      {path:'accomodation',component: AccomodationComponent},
      {path:'add-type',component: AddTypeComponent},
      {path:'add-service',component: AddServiceComponent}
      {path:'add-category',component: AddCategoryComponent}
    ]}
];


export const routing = RouterModule.forRoot(APP_ROUTES);
