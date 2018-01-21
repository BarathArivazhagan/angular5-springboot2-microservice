import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutes} from './app.routing';


import { AppComponent } from './app.component';
import { AddInventoryComponent } from './add-inventory/add-inventory.component';
import { GetInventoryComponent } from './get-inventory/get-inventory.component';
import { UpdateInventoryComponent } from './update-inventory/update-inventory.component';
import { DeleteInventoryComponent } from './delete-inventory/delete-inventory.component';
import { GetInventoryListComponent } from './get-inventory-list/get-inventory-list.component';


@NgModule({
  declarations: [
    AppComponent,
    AddInventoryComponent,
    GetInventoryComponent,
    UpdateInventoryComponent,
    DeleteInventoryComponent,
    GetInventoryListComponent
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
