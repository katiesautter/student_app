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

  /**{
    path: '{{event.title}}',
    component: EventDetailsComponent,
    data: { title: '{{event.title}}' }
  }, */

  {
    path: 'events',
    component: EventsComponent,
    data: { title: 'events' }
  },

  { path: '',
    redirectTo: '/events',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
