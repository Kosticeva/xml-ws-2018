import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { FilterComponent } from './filter/filter.component';
import { HomeComponent } from './home/home.component';
import { AccommodationPageComponent } from './accommodation/accommodation-page.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { MenubarComponent } from './menubar/menubar.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { MessagesComponent } from './messages/messages.component';
import { FilterService } from './filter/filter.service';


@NgModule({
  declarations: [
    AppComponent,
    FilterComponent,
    HomeComponent,
    AccommodationPageComponent,
    LoginComponent,
    MenubarComponent,
    ProfileComponent,
    RegisterComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	FormsModule,
	HttpClientModule
  ],
  providers: [FilterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
