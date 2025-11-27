import { Component, OnInit } from '@angular/core';
import { Product } from '../../../models/Product';
import { ProductService } from '../../../services/product-service';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-product-list',
  imports: [MatTableModule, MatCardModule],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css',
})
export class ProductList implements OnInit {
  products: Product[] = [];
  columns = ['id', 'name', 'price', 'quantity'];

  constructor(private service: ProductService) {}

  ngOnInit() {
    this.service.getProducts().subscribe(data => this.products = data);
  }
}
