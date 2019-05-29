// Importar módulos del router

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Importar componentes

import { InterfaceComponent } from './component/interface/interface.component';
import { AppComponent } from './app.component';

// Array de routas

 const appRoutes: Routes = [
     { path: 'interface', component:  InterfaceComponent},
     { path: '', component:  AppComponent},

 ]
 //Exportar el módulo del router

 export const appRoutingProviders: any [] = [];
 export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);