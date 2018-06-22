import { Component, OnInit } from '@angular/core';
import { MessageService } from '../shared/message/message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  private messages: Array<any>;

  constructor(private messageService: MessageService) { }

  ngOnInit() {
    
  }

  getMessages() {
    this.messageService.getAll().subscribe(data => {
      this.messages = data;
    });
  }

}
