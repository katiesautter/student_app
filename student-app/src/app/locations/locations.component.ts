import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit {

  locations = [];
  //[{"id":1,"title":"Game Night","status":"public","datetime":"2019-12-12 14:52:09.952142","fk_location":1},{"id":2,"title":"Welcome Back Bash","status":"public","datetime":"2019-12-12 14:52:10.162947","fk_location":2},{"id":4,"title":"Volleyball Game","status":"public","datetime":"2019-12-12 14:52:10.18508","fk_location":5},{"id":7,"title":"Karaoke Night","status":"public","datetime":"2019-12-12 14:52:10.218348","fk_location":6},{"id":8,"title":"International CLub Meeting","status":"public","datetime":"2019-12-12 14:52:10.229349","fk_location":6},{"id":9,"title":" bball!","status":"public","datetime":"2019-12-11 21:08:44.0","fk_location":5},{"id":10,"title":" bball!","status":"public","datetime":"2019-12-11 21:08:44.0","fk_location":5}];
  
  constructor(
    private http: HttpClient, private seaService: SeaService
  ) { }

  
  ngOnInit() {
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

}
