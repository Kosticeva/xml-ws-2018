import { Component, OnInit } from '@angular/core';
import {UsersService} from "./users.service";
import {User} from "../model/user";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.usersService.getPendingUsers().subscribe(
      (data: User[]) => {
        this.users = data;
      }
    );
  }

  approve(u: User){
    var r = confirm("Are u sure?");
    if (r == true) {
      this.usersService.approveUser(u).subscribe(
        (data: User) => {
          this.users.splice(this.users.indexOf(u), 1);
        }
      );
    }
  }

  decline(u: User){
    var r = confirm("Are u sure?");
    if (r == true) {
      this.usersService.declineUser(u).subscribe(
        (data: User) => {
          this.users.splice(this.users.indexOf(u), 1);
        }
      );
    }
  }

}
