import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventsComponent } from './events/events.component';


const routes: Routes = [
  {
    path: 'eventsdetail',
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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
