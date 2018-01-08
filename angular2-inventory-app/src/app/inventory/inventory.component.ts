import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    console.log('Inventory Component onInit is called');
  }

  submit(form: FormGroup) {
    console.log('Template-driven form submitted: ', form);
  }

}

interface Inventory {
  inventoryName: string;
  productName: string;
  quantity: number;

}
