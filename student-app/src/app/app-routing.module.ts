import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventsComponent } from './events/events.component';
import { LocationsComponent } from './locations/locations.component';
import { LocationDetailsComponent} from './location-details/location-details.component'
import { DiscussionsComponent } from './discussions/discussions.component';
import { LoginComponent } from './login/login.component';
import { DiscussionDetailsComponent } from './discussion-details/discussion-details.component';
import { UserComponent } from './user/user.component';
import { MapComponent } from './map/map.component';


const routes: Routes = [
  {
    path: 'eventsdetails/:id',
    component: EventDetailsComponent,
    data: { title: 'events' }
  }, 

  {
    path: 'events',
    component: EventsComponent,
    data: { title: 'events' }
  },

  {
    path: 'locations',
    component: LocationsComponent,
    data: { title: 'locations' }
  },

  { path: '',
    redirectTo: '/events',
    pathMatch: 'full'
  },

  {
    path: 'locationsdetails/:id',
    component: LocationDetailsComponent,
    data: { title: 'locations' }
  }, 

  {
    path: 'discussions',
    component: DiscussionsComponent,
    data: { title: 'discussions' }
  }, 

  {
    path: 'login',
    component: LoginComponent,
    data: { title: 'login' }
  }, 

  {
    path: 'discussiondetails/:id',
    component: DiscussionDetailsComponent,
    data: { title: 'discussiondetails' }
  }, 

  {
    path: 'user',
    component: UserComponent,
    data: { title: 'user' }
  }, 

  {
    path: 'map',
    component: MapComponent,
    data: { title: 'map' }
  } 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
