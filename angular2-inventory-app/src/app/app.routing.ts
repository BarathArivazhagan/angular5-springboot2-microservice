import {Router, RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {AddInventoryComponent} from './inventory/add-inventory/add-inventory.component';
import {GetInventoryComponent} from './inventory/get-inventory/get-inventory.component';
import {UpdateInventoryComponent} from './inventory/update-inventory/update-inventory.component';
import {DeleteInventoryComponent} from './inventory/delete-inventory/delete-inventory.component';

const router: Routes = [

 {path: '', redirectTo: '/', pathMatch: 'full'},
 {path: 'saveInventory', component: AddInventoryComponent},
 {path: 'getInventory', component: GetInventoryComponent},
 {path: 'updateInventory', component: UpdateInventoryComponent},
 {path: 'inventories', component: GetInventoryComponent}
];

export const AppRoutes = RouterModule.forRoot(router);
