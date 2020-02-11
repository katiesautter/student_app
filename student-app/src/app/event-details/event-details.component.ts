import { Component, OnInit, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { SeaService } from '../sea.service';



@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html', 
  styleUrls: ['./event-details.component.css']
})


export class EventDetailsComponent implements OnInit {

  id: String;
  posts = ["No posts for this event"];
  event = {title: undefined, datetime: undefined, locationName: undefined};
  //[{"id":3,"message":"Come support the girls volleyball team!!","user_id":2,"event_id":4},{"id":4,"message":"Volleyball game tonight!!","user_id":2,"event_id":4}];
  
  constructor(private route: ActivatedRoute, private http: HttpClient, private seaService: SeaService) { }
  

  ngOnInit() {
  
    this.id = this.route.snapshot.params.id;


    console.log("about to get posts");
    //this.http.get<any>("http://localhost:8080/student-engagement-app-1.0-SNAPSHOT/rest/Events/" + this.id)
    this.http.get<any>(this.seaService.restUrl() + "Events/" + this.id)
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
