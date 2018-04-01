import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import {environment} from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import {InventoryService} from './../services/inventory.service';

@Component({
  selector: 'app-add-inventory',
  providers: [InventoryService],
  templateUrl: './add-inventory.component.html',
  styleUrls: ['./add-inventory.component.css']
})
export class AddInventoryComponent implements OnInit {

  constructor(private inventoryService: InventoryService) { }

   submit(form: FormGroup) {
    console.log('Template-driven form submitted: ', form.value);
    const inventoryBody = form.value;
    console.log('LOG ' + JSON.stringify(inventoryBody));
    this.inventoryService.addInventory(inventoryBody).subscribe(
       data => {
         console.log('Successful response' + data);
       },
      err => {
        console.log('Something went wrong!');
      });
  }

  ngOnInit() {
  }

}
