import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { Invoice } from '../../../models/Invoice';
import { BillingService } from '../../../services/billing-service';

@Component({
  selector: 'app-invoice-list',
  imports: [MatTableModule, MatCardModule],
  templateUrl: './invoice-list.html',
  styleUrl: './invoice-list.css',
})
export class InvoiceList implements OnInit {
  invoices: Invoice[] = [];
  columns = ['id', 'customerId', 'date'];

  constructor(private service: BillingService) {}

  ngOnInit() {
    this.service.getInvoices().subscribe(data => this.invoices = data);
  }
}
