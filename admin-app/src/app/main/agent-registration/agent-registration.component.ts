import { Component, OnInit } from '@angular/core';
import {AgentService} from "./agent.service";
import {Agent} from "../model/agent";
import {Router} from "@angular/router";

@Component({
  selector: 'app-agent-registration',
  templateUrl: './agent-registration.component.html',
  styleUrls: ['./agent-registration.component.css']
})
export class AgentRegistrationComponent implements OnInit {

  constructor(private agentService: AgentService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(agent: Agent) {
    this.agentService.registerAgent(agent).subscribe(
      (data) => {
        alert("Successful agent registration");
        this.router.navigateByUrl('/home');
      }
    );
  }
}
