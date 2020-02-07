import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-location-details',
  templateUrl: './location-details.component.html',
  styleUrls: ['./location-details.component.css']
})
export class LocationDetailsComponent implements OnInit {

  id: String;
  location = {};
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;


    console.log("about to get location");
    this.http.get<any>("http://localhost:8080/student-engagement-app-1.0-SNAPSHOT/rest/Locations/" + this.id)
        .subscribe( response => { 
          this.location = response.Location;
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
        }
        ) 
  }


}
