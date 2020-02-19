import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SeaService {

  constructor() { }


  restUrl()
  {
    if ((document.baseURI == "http://localhost:4200/") || (document.baseURI == "http://localhost:8080/"))
    {
        return "http://localhost:8080/student-engagement-app-1.0-SNAPSHOT/rest/"
 
    } 
    else
    {
        return "http://ec2-3-132-225-35.us-east-2.compute.amazonaws.com:80/rest/"
    }
    
  }

}