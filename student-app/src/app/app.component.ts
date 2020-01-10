import { Component, APP_INITIALIZER } from '@angular/core';
import { by } from 'protractor';
import { NgLocalization } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Student Engagement App';
  events=['Volleyball Game', 'Game Night','Study Session','Living Issues Study Group','Chess Tournament', 'Floor Meetings']; 
}



