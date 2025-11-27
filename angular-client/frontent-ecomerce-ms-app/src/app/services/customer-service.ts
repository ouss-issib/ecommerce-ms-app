import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/Customer';
@Injectable({ providedIn: 'root' })
export class CustomerService {
  private baseUrl = 'http://localhost:8888/CUSTOMER-SERVICE/customers';

  constructor(private http: HttpClient) {}

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl);
  }
}
