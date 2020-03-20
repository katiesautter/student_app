import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.css']
})
export class AddUsersComponent implements OnInit {

  users = [];

  constructor( private http: HttpClient, private seaService: SeaService) { }

    
  ngOnInit() {
    console.log("about to get discussions");
    this.http.get<any>(this.seaService.restUrl() + "Users")
        .subscribe( response => { 
           this.users = response.Users;
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
        }
        ) 


  } 

}
