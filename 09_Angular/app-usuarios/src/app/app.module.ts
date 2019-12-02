import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { NuevaCuentaComponent } from './nueva-cuenta/nueva-cuenta.component';
import { HttpClientModule } from '@angular/common/http';
import { ListaCuentasComponent } from './lista-cuentas/lista-cuentas.component';
import { ModificarCuentaComponent } from './modificar-cuenta/modificar-cuenta.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    NuevaCuentaComponent,
    ListaCuentasComponent,
    ModificarCuentaComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
