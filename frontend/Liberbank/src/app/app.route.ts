// Importar módulos del router

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Importar componentes

import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { SaldoComponent } from './component/saldo/saldo.component';
import { TransferenciasComponent } from './component/transferencias/transferencias.component';
import { TransferenciasPeriodicasComponent } from './component/transferencias-periodicas/transferencias-periodicas.component'
import { HomeComponent } from './component/home/home.component';

// Array de routas

 const appRoutes: Routes = [

     { path: '', component: HomeComponent },
     { path: 'login', component: LoginComponent },
     { path: 'saldo', component: SaldoComponent },
     { path: 'transferencias', component: TransferenciasComponent },
     { path: 'transferencias-periodicas', component: TransferenciasPeriodicasComponent },

 ]
 //Exportar el módulo del router

 export const appRoutingProviders: any [] = [];
 export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);