import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { appRoutingProviders, routing } from './app.route';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { SaldoComponent } from './component/saldo/saldo.component';
import { TransferenciasComponent } from './component/transferencias/transferencias.component';
import { TransferenciasPeriodicasComponent } from './component/transferencias-periodicas/transferencias-periodicas.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SaldoComponent,
    TransferenciasComponent,
    TransferenciasPeriodicasComponent,
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
