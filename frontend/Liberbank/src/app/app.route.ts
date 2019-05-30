// Importar módulos del router

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Importar componentes

import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { PerfilComponent } from './component/perfil/perfil.component';

// Array de routas

 const appRoutes: Routes = [

     { path: '', component:  LoginComponent},
     { path: 'login', component: LoginComponent },
     { path: 'perfil', component: PerfilComponent }


 ]
 //Exportar el módulo del router

 export const appRoutingProviders: any [] = [];
 export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);