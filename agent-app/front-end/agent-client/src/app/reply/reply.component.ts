import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from '../shared/message/message.service';

@Component({
  selector: 'app-reply',
  templateUrl: './reply.component.html',
  styleUrls: ['./reply.component.css']
})
export class ReplyComponent implements OnInit {

  messageId: number;
  message: any;
  replyText: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private messageService: MessageService
  ) {
    this.replyText = "";
    this.route.params.subscribe( params => this.messageId = +params['id']);
  }

  ngOnInit() {
    this.messageService.get(this.messageId).subscribe(data => {
      this.message = data;
    });
    this.messageService.seen(this.messageId).subscribe();
  }

  sendMessage() {
    let messageDTO = {}; 
    messageDTO['receiver'] = this.message['user']['username'];
    messageDTO['content'] = this.replyText;
    this.messageService.send(messageDTO).subscribe();
    this.replyText = "";
    this.router.navigate(['/messages']);
  }

}
