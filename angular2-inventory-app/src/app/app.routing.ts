import {Router, RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {AddInventoryComponent} from './add-inventory/add-inventory.component';
import {GetInventoryComponent} from './get-inventory/get-inventory.component';
import {UpdateInventoryComponent} from './update-inventory/update-inventory.component';
import {DeleteInventoryComponent} from './delete-inventory/delete-inventory.component';
import {GetInventoryListComponent} from './get-inventory-list/get-inventory-list.component';

const router: Routes = [

 {path: '', redirectTo: '/', pathMatch: 'full'},
 {path: 'saveInventory', component: AddInventoryComponent},
 {path: 'getInventory', component: GetInventoryComponent},
 {path: 'updateInventory', component: UpdateInventoryComponent},
 {path: 'inventories', component: GetInventoryListComponent}
];

export const AppRoutes = RouterModule.forRoot(router);
