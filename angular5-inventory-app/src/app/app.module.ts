import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutes} from './app.routing';


import { AppComponent } from './app.component';
import {AddInventoryComponent} from './inventory/add-inventory/add-inventory.component';
import {GetInventoryComponent} from './inventory/get-inventory/get-inventory.component';
import {UpdateInventoryComponent} from './inventory/update-inventory/update-inventory.component';
import {DeleteInventoryComponent} from './inventory/delete-inventory/delete-inventory.component';
import { InventoryComponent } from './inventory/inventory.component';


@NgModule({
  declarations: [
    AppComponent,
    AddInventoryComponent,
    GetInventoryComponent,
    UpdateInventoryComponent,
    DeleteInventoryComponent,
    InventoryComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutes
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
