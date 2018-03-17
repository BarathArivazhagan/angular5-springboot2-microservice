import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { InventoryService } from './../services/inventory.service';
import { Inventory } from './../services/inventory.service';

@Component({
  selector: 'app-get-inventory',
  providers: [InventoryService],
  templateUrl: './get-inventory.component.html',
  styleUrls: ['./get-inventory.component.css']
})
export class GetInventoryComponent implements OnInit {

  public inventories: Inventory[];

  constructor(private inventoryService: InventoryService) { }

  ngOnInit() {

   this.inventoryService.getInventories().subscribe( data => {
      console.log(' inventories ' + data);
      this.inventories = data;
   });
  }

}
