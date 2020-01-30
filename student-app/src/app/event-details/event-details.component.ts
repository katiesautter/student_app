import { Component, OnInit, Input } from '@angular/core';
//import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
//import { switchMap } from 'rxjs/operators';
//import { BrowserModule } from '@angular/platform-browser';
//import { NgModule } from '@angular/core';
//import { Timestamp } from 'rxjs/internal/operators/timestamp';
//import { EventsComponent } from './events/events.component';


@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html', 
  styleUrls: ['./event-details.component.css']
})


export class EventDetailsComponent implements OnInit {

 /* @Input() id: string;
  @Input() title: string;
  @Input() status: string;
  //@Input() datetime: Timestamp;
  @Input() fk_location: string; */
  id: String;
 // title: String;
  posts = [];
  event = {};
  //[{"id":3,"message":"Come support the girls volleyball team!!","user_id":2,"event_id":4},{"id":4,"message":"Volleyball game tonight!!","user_id":2,"event_id":4}];
  //sub: any;
  //service: any;
  constructor(private route: ActivatedRoute, private http: HttpClient) { }
  

  ngOnInit() {
  
    this.id = this.route.snapshot.params.id;


    console.log("about to get posts");
    this.http.get<any>("http://localhost:8080/student-engagement-app-1.0-SNAPSHOT/rest/Events/" + this.id)
        .subscribe( response => { 
          console.log("return from get posts for event");
          this.posts = response.Posts;
          this.event = response.Event;
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
        }
        ) 
    console.log("after call to get event posts");

 
  } 

}
