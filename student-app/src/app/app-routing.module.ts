import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventsComponent } from './events/events.component';
import { LocationsComponent } from './locations/locations.component';
import { LocationDetailsComponent} from './location-details/location-details.component'


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

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
