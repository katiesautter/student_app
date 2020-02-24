import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  events = [];
  username = " ";
  password = " ";

  constructor(
    private http: HttpClient, private seaService: SeaService
  ) { }

  ngOnInit() {
  }

  onSubmit() 
  {

    //console.log("creating a new user" + this.);
    //'11-12-2019 21:08:44'
    this.http.post<any>(this.seaService.restUrl() + "Users/", { username: this.username, password: this.password})
        .subscribe( response => { 
          this.username = response.username;
          this.password = response.password;
          
        
        }, err => {
          console.log(err.message);

        }, () => {
          console.log('completed');
          window.location.reload();   
          
        }
        )
       
       
  }
}
