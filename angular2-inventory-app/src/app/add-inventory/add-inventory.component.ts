import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import {environment} from '../../environments/environment';

@Component({
  selector: 'app-add-inventory',
  templateUrl: './add-inventory.component.html',
  styleUrls: ['./add-inventory.component.css']
})
export class AddInventoryComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
    console.log('Add Inventory Component onInit is called');
  }

  submit(form: FormGroup) {
    console.log('Template-driven form submitted: ', form.value);
    const inventoryBody = form.value;
    console.log('LOG ' + JSON.stringify(inventoryBody));
    this.http.post(environment.appServiceUrl + '/saveInventory', inventoryBody)
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

  constructor(inventoryName: string, productName: string, quantity: number) {  }

}
