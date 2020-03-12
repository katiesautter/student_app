import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-discussions',
  templateUrl: './discussions.component.html',
  styleUrls: ['./discussions.component.css']
})
export class DiscussionsComponent implements OnInit {

  discussions = [];
  eventTitle = " ";
  eventDate = " ";
  //[{"id":1,"title":"Game Night","status":"public","datetime":"2019-12-12 14:52:09.952142","fk_location":1},{"id":2,"title":"Welcome Back Bash","status":"public","datetime":"2019-12-12 14:52:10.162947","fk_location":2},{"id":4,"title":"Volleyball Game","status":"public","datetime":"2019-12-12 14:52:10.18508","fk_location":5},{"id":7,"title":"Karaoke Night","status":"public","datetime":"2019-12-12 14:52:10.218348","fk_location":6},{"id":8,"title":"International CLub Meeting","status":"public","datetime":"2019-12-12 14:52:10.229349","fk_location":6},{"id":9,"title":" bball!","status":"public","datetime":"2019-12-11 21:08:44.0","fk_location":5},{"id":10,"title":" bball!","status":"public","datetime":"2019-12-11 21:08:44.0","fk_location":5}];
  
  constructor(
    private http: HttpClient, private seaService: SeaService
  ) { }

  
  ngOnInit() {
    console.log("about to get discussions");
    this.http.get<any>(this.seaService.restUrl() + "Events/Private")
        .subscribe( response => { 
           this.discussions = response.PrivateEvents;
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
    this.http.post<any>(this.seaService.restUrl() + "Events/", { title: this.eventTitle, date_time: this.eventDate, status: 'private', location_id: '2'})
        .subscribe( response => { 
          this.eventTitle = response.title;
          this.eventDate = response.date_time;
          
        
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
          window.location.reload();   
          
        }
        )
       
       
  }

}
