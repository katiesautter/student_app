import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventsComponent } from './events/events.component';


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

  { path: '',
    redirectTo: '/events',
    pathMatch: 'full'
  },

/*  {path : 'events', 
  component : EventDetailsComponent, 
  data : {id : 'event.id', title : 'event.title', status : 'event.status', date_time : 'event.date_time', fk_location_id : 'event.fk_location_id'}
  }, */



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
