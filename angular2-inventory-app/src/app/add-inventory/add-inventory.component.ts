import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-inventory',
  templateUrl: './add-inventory.component.html',
  styleUrls: ['./add-inventory.component.css']
})
export class AddInventoryComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    console.log('Add Inventory Component onInit is called');
  }

  submit(form: FormGroup) {
    console.log('Template-driven form submitted: ', form.value);
  }

}

interface Inventory {
  inventoryName: string;
  productName: string;
  quantity: number;

}
