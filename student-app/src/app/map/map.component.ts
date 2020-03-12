import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {


  d = new Date();
  id = 4;
  locationid: String;
  postInfo = " ";
  location = {name: undefined, id: undefined};
  posts = ["No posts for this event"];
  event = {title: undefined, datetime: undefined, locationName: undefined, fk_location: undefined};
  //[{"title":"Game Night","datetime":"2019-09-06 00:00:00.0","locationname":2,"event_id":4},{"id":4,"message":"Volleyball game tonight!!","user_id":2,"event_id":4}];

  
  constructor(private route: ActivatedRoute, private http: HttpClient, private seaService: SeaService) { }


  ngOnInit() {

  }

  onSubmit(){

    this.id = this.route.snapshot.params.id;


    console.log("about to get posts");
    //this.http.get<any>("http://localhost:8080/student-engagement-app-1.0-SNAPSHOT/rest/Events/" + this.id)
    this.http.get<any>(this.seaService.restUrl() + "Events/" + this.id)
        .subscribe( response => { 
          console.log("return from get posts for event");
          this.posts = response.Posts;
          this.event = response.Event;

          this.locationid = this.event.fk_location;

            this.http.get<any>(this.seaService.restUrl() + "Locations/" + this.locationid)
            .subscribe( response => { 
              this.location = response.Location;
            }, err => {
              console.log(err.message);

            }, () => {
              console.log('completed');
            }
            )

        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
        }
        ) 
    console.log("after call to get event posts");
  }

}
