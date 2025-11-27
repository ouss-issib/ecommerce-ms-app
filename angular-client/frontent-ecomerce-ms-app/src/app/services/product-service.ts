import { Product } from './../models/Product';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ProductService {
  private baseUrl = 'http://localhost:8888/inventory-service/products';

  constructor(private http: HttpClient) {}

  getProducts(): Observable<Product[]> {
  return this.http.get<{ _embedded: { products: Product[] } }>(this.baseUrl)
    .pipe(
      map(response => response._embedded.products)
    );
}
}
