import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events=['Volleyball Game', 'Game Night','Study Session','Living Issues Study Group','Chess Tournament', 'Floor Meetings']; 

  constructor() { }

  ngOnInit() {
  }



}
