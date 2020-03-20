import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS }    from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventsComponent } from './events/events.component';
import { EventDetailsComponent } from './event-details/event-details.component';
import { LocationsComponent } from './locations/locations.component';
import { LocationDetailsComponent } from './location-details/location-details.component';import { FormsModule }   from '@angular/forms';
import { DiscussionsComponent } from './discussions/discussions.component';
import { LoginComponent } from './login/login.component';
import { DiscussionDetailsComponent } from './discussion-details/discussion-details.component';
import { UserComponent } from './user/user.component';
import { MapComponent } from './map/map.component';
import {HttpEvent, HttpInterceptor, HttpHandler, HttpRequest} from '@angular/common/http';
import { SeaService } from './sea.service';
import { SidebarModule } from 'ng-sidebar';
import { AddUsersComponent } from './add-users/add-users.component';


@NgModule({
  declarations: [
    AppComponent,
    EventsComponent,
    EventDetailsComponent,
    LocationsComponent,
    LocationDetailsComponent,
    DiscussionsComponent,
    LoginComponent,
    DiscussionDetailsComponent,
    UserComponent,
    MapComponent,
    AddUsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide : HTTP_INTERCEPTORS,
      useClass: SeaService,
      multi   : true
    } 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
