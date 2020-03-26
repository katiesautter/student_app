import { Injectable, Injector } from '@angular/core';
import {HttpEvent, HttpInterceptor, HttpHandler, HttpRequest} from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})

@Injectable()
export class SeaService  implements HttpInterceptor{
  
  token: String;
  constructor(private injector: Injector) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let seaService = this.injector.get(SeaService);
    if (seaService.token) 
    {
      req = req.clone({
        setHeaders: {
          Authorization: `Bearer ${seaService.token}`
        }
      });
    }
    
    return next.handle(req);
  }

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


  loggedIn()
  {
    if (this.token === undefined )
      return false;
    else
      return true;
  } 

  
}