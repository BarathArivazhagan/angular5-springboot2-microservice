import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import {environment} from './../../../environments/environment';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/do';

@Injectable()
export class InventoryService {

   constructor(private http: HttpClient) { }

  addInventory(inventory: Inventory) {
    return this.http.post(environment.appServiceUrl + '/', inventory);
  }

  getInventories(): Observable<any> {
   return this.http.get(environment.appServiceUrl + '/all');
   }

}


export class Inventory {

  constructor(public productName: string, public locationName: string, public quantity: number) {  }

}
