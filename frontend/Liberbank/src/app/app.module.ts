import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { APPROUTINGPROVIDERS, ROUTING } from './app.route';

import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
