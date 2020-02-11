import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-location-details',
  templateUrl: './location-details.component.html',
  styleUrls: ['./location-details.component.css']
})
export class LocationDetailsComponent implements OnInit {

  id: String;
  location = {name: undefined, id: undefined};
  constructor(private route: ActivatedRoute, private http: HttpClient, private seaService: SeaService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;


    console.log("about to get location");
    this.http.get<any>(this.seaService.restUrl() + "Locations/" + this.id)
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
