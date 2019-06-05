import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { appRoutingProviders, routing } from './app.route';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { DatosPersonalesComponent } from './component/datos-personales/datos-personales.component';
import { BlockchainComponent } from './component/blockchain/blockchain.component';
import { TransaccionesComponent } from './component/transacciones/transacciones.component';
import { CuentaComponent } from './component/cuenta/cuenta.component';
import { DesgloseCuentaComponent } from './component/desglose-cuenta/desglose-cuenta.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DatosPersonalesComponent,
    BlockchainComponent,
    TransaccionesComponent,
    CuentaComponent,
    DesgloseCuentaComponent
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
