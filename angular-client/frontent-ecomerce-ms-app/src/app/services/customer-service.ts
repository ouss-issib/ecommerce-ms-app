import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Customer } from '../models/Customer';
@Injectable({ providedIn: 'root' })
export class CustomerService {
  private baseUrl = 'http://localhost:8888/customer-service/customers';

  constructor(private http: HttpClient) {}

  getCustomers(): Observable<Customer[]> {
  return this.http.get<{ _embedded: { customers: Customer[] } }>(this.baseUrl)
    .pipe(
      map(response => response._embedded.customers)
    );
}
}
