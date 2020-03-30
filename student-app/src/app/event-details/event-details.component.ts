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

  d = new Date();
  id: String;
  locationid: String;
  postInfo = "";
  location = {name: undefined, id: undefined};
  posts = ["No posts for this event"];
  event = {title: undefined, datetime: undefined, locationName: undefined, fk_location: undefined};
  
  //[{"id":3,"message":"Come support the girls volleyball team!!","user_id":2,"event_id":4},{"id":4,"message":"Volleyball game tonight!!","user_id":2,"event_id":4}];
  
  constructor(private route: ActivatedRoute, private http: HttpClient, public seaService: SeaService) { }
  

  ngOnInit() {
  
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


   // this.locationid = this.route.snapshot.params.id;

    
 

 
  } 

  onSubmit() 
  {
   // var d = new Date(); 
   // d = new Date(d.getTime() - 3000000);
   // var date_format_str = d.getFullYear().toString()+"-"+((d.getMonth()+1).toString().length==2?(d.getMonth()+1).toString():"0"+(d.getMonth()+1).toString())+"-"+(d.getDate().toString().length==2?d.getDate().toString():"0"+d.getDate().toString())+" "+(d.getHours().toString().length==2?d.getHours().toString():"0"+d.getHours().toString())+":"+(((d.getMinutes()/5)*5).toString().length==2?(((d.getMinutes()/5)*5)-10).toString():"0"+((d.getMinutes()/5)*5).toString())+":00";
    //console.log(date_format_str);
     //var d = new Date(); 
      //d = new Date(d.getTime());

    this.id = this.route.snapshot.params.id;

    console.log("creating a new post" + this.postInfo);
    //'11-12-2019 21:08:44'
    this.http.post<any>(this.seaService.restUrl() + "Posts/", { message: this.postInfo, fk_user_id: '3', fk_events_id: this.id})
        .subscribe( response => { 
          console.log("return from get posts for event");
          this.postInfo = response.message;
          this.id = response.fk_events_id;
          this.posts.push(response.Post);

        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
         // window.location.reload();   
         // console.log(date_format_str);
         
        }
        )
       
  }
  

}
