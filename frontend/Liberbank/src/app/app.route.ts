// Importar módulos del router

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Importar componentes

import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { DatosPersonalesComponent } from './component/datos-personales/datos-personales.component';
import { BlockchainComponent } from './component/blockchain/blockchain.component';
import { TransaccionesComponent } from './component/transacciones/transacciones.component';
// Array de routas

 const appRoutes: Routes = [
     { path: 'login', component: LoginComponent },
     { path: 'blockchain', component: BlockchainComponent },
     { path: 'transacciones', component: TransaccionesComponent },
     { path: 'datos-personales', component: DatosPersonalesComponent }

 ]
 //Exportar el módulo del router

 export const appRoutingProviders: any [] = [];
 export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);