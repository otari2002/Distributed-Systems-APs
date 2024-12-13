import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private baseUrl = 'http://localhost:8086/api';

  constructor(private http: HttpClient) {}

  getAllOrders(): Observable<any> {
    return this.http.get(`${this.baseUrl}/orders`);
  }

  getOrderById(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/orders/${id}`);
  }

  getAllProducts(): Observable<any> {
    return this.http.get(`${this.baseUrl}/inventory`);
  }
}
