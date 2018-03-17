import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import {environment} from './../../../environments/environment';

@Injectable()
export class InventoryService {

   constructor(private http: HttpClient) { }

  addInventory(inventory: Inventory) {
    return this.http.post(environment.appServiceUrl + '/saveInventory', inventory)
      .subscribe(
       data => {
         console.log('Successful response' + data);
       },
      err => {
        console.log('Something went wrong!');
      });
  }

}


export class Inventory {

  constructor(inventoryId: number, productName: string, locationName: string, quantity: number) {  }

}
