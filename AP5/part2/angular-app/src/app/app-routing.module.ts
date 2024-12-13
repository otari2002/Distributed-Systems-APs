import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderListComponent } from './components/order-list/order-list.component';
import { OrderDetailsComponent } from './components/order-details/order-details.component';
import { HomeComponent } from './home/home.component';
import { InventoryComponent } from './components/inventory/inventory.component';
import { KeycloakGuard } from './auth/keycloak.guard';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { 
    path: 'inventory', 
    component: InventoryComponent,
    canActivate: [KeycloakGuard],
    data: { roles: ['ADMIN'] }
  },
  { 
    path: 'orders', 
    component: OrderListComponent,
    canActivate: [KeycloakGuard],
    data: { roles: ['USER', 'ADMIN'] }
  },
  { 
    path: 'orders/:id', 
    component: OrderDetailsComponent,
    canActivate: [KeycloakGuard],
    data: { roles: ['USER', 'ADMIN'] } 
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
