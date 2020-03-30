import { Component, OnInit, Input } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

events = [];
locations = [];
eventTitle = "";
eventDate = "";
eventLocation = "";
  //[{"id":1,"title":"Game Night","status":"public","datetime":"2019-12-12 14:52:09.952142","fk_location":1},{"id":2,"title":"Welcome Back Bash","status":"public","datetime":"2019-12-12 14:52:10.162947","fk_location":2},{"id":4,"title":"Volleyball Game","status":"public","datetime":"2019-12-12 14:52:10.18508","fk_location":5},{"id":7,"title":"Karaoke Night","status":"public","datetime":"2019-12-12 14:52:10.218348","fk_location":6},{"id":8,"title":"International CLub Meeting","status":"public","datetime":"2019-12-12 14:52:10.229349","fk_location":6},{"id":9,"title":" bball!","status":"public","datetime":"2019-12-11 21:08:44.0","fk_location":5},{"id":10,"title":" bball!","status":"public","datetime":"2019-12-11 21:08:44.0","fk_location":5}];
  
  constructor(
    private http: HttpClient, public seaService: SeaService
  ) { }

  
  ngOnInit() {
    console.log("about to get events");
    this.http.get<any>(this.seaService.restUrl() + "Events")
        .subscribe( response => { 
          console.log("return from get events");
           this.events = response.PublicEvents;
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
        }
        ) 
    console.log("after call to get events"); 




    console.log("about to get locations");
    this.http.get<any>(this.seaService.restUrl() + "Locations")
        .subscribe( response => { 
           this.locations = response.Locations;
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
        }
        ) 
  } 


  onSubmit() 
  {

    console.log("creating a new event" + this.eventTitle);
    //'11-12-2019 21:08:44'
    this.http.post<any>(this.seaService.restUrl() + "Events/", { title: this.eventTitle, date_time: this.eventDate, status: 'public', location_id: '2'})
        .subscribe( response => { 
          this.eventTitle = response.title;
          this.eventDate = response.date_time;
          this.events.push(response.Event);
          
        
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
        //  window.location.reload();   
          
        }
        )
       
       
  }
  

}





