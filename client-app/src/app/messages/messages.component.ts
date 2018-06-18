import { Component, OnInit } from '@angular/core';
import { MessagesService } from './messages.service';
import { Message } from '../model/message';
import { Agent } from '../model/agent';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css'],
  providers: [ MessagesService ]
  
})
export class MessagesComponent implements OnInit {

	messages: Message[] = [];
	agents:Agent[] = [];
	selectedAgent:Agent = undefined;
	message:Message = new Message();
	
	constructor(private messagesService : MessagesService) { }

	ngOnInit() {
		this.getAgents();
	}
	
	getAgents() {
		this.messagesService.getAgents().subscribe(agents => this.agents = agents);
	}
	
	getMessages(agent) {
		this.selectedAgent = agent;
		this.messagesService.getMessages(this.selectedAgent.username).subscribe(messages => this.messages = messages);
	}
	
	sendMessage() {
		this.message.sender = 'USER';
		this.message.agentUsername = this.selectedAgent.username;
		this.messagesService.sendMessage(
			this.message,
			() => { /*poruka poslata*/ this.message.content = ""; this.getMessages(this.selectedAgent) },
			() => { /*nesto puklo*/ });
	}
}
