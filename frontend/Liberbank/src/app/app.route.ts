// Importar módulos del router

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Importar componentes

import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { DatosPersonalesComponent } from './component/datos-personales/datos-personales.component';
import { BlockchainComponent } from './component/blockchain/blockchain.component';
import { TransaccionesComponent } from './component/transacciones/transacciones.component';
import { CuentaComponent } from './component/cuenta/cuenta.component';
import { DesgloseCuentaComponent } from './component/desglose-cuenta/desglose-cuenta.component';


// Array de routas

 const appRoutes: Routes = [
     { path: 'login', component: LoginComponent },
     { path: 'blockchain', component: BlockchainComponent },
     { path: 'transacciones', component: TransaccionesComponent },
     { path: 'datos-personales', component: DatosPersonalesComponent },
     { path: 'cuenta', component: CuentaComponent },
     { path: 'cuenta-desglose', component: DesgloseCuentaComponent }

 ]

 //Exportar el módulo del router

 export const appRoutingProviders: any [] = [];
 export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
