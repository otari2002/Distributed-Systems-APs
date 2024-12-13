import { Component } from '@angular/core';
import { OrderService } from '../../services/order.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrl: './inventory.component.css'
})

export class InventoryComponent {
  inventory: InventoryItem[] = [];

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    this.orderService.getAllProducts().subscribe((data) => {
      this.inventory = data;
    });
  }
}

interface InventoryItem {
  id: string;
  name: string;
  price: number;
  quantity: number;
}