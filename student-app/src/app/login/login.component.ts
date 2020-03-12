import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { SeaService } from '../sea.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id: String;
  loginUsername = " ";
  loginPassword = " ";

  constructor(private route: ActivatedRoute, private http: HttpClient, private seaService: SeaService) { }
  

  ngOnInit() {
  }

  onSubmit() 
  { 
    this.http.post(this.seaService.restUrl() + "Users/Login/", 
        { username: this.loginUsername, password: this.loginPassword},
         {observe: 'response', responseType: 'text'})
      .subscribe( response => { 
         console.log("adding login user");
         this.seaService.token = response.body;  
      
    }, err => {
      console.log(err.message);

    }, () => {
      console.log('completed');
    //  window.location.reload();   
    }
    )
  }
}
