import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { appRoutingProviders, routing } from './app.route';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { InterfaceComponent } from './component/interface/interface.component';

@NgModule({
  declarations: [
    AppComponent,
    InterfaceComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    routing

  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
