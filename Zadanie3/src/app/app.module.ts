import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }   from '@angular/router';



import { AppComponent } from './app.component';
//import { PeopleComponent } from './people.component';
import { MycomponentComponent } from './mycomponent/mycomponent.component';
//import { PersonDetailComponent } from './person-detail.component';
//import { PersonService } from './person.service';
import { DashboardComponent } from './dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    MycomponentComponent,
//    PersonDetailComponent,
    DashboardComponent,
   // PeopleComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
      //  RouterModule.forRoot([
      //{
  //path: 'dashboard/:name',
  //component: DashboardComponent
//},
  //  ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
