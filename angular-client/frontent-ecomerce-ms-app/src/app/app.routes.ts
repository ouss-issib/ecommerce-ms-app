import { Routes } from '@angular/router';
import { CustomerList } from './components/customers/customer-list/customer-list';
import { ProductList } from './components/products/product-list/product-list';
import { InvoiceList } from './components/invoices/invoice-list/invoice-list';

export const routes: Routes = [
  { path: '', redirectTo: 'customers', pathMatch: 'full' },
  { path: 'customers', component: CustomerList},
  { path: 'products', component: ProductList },
  { path: 'invoices', component: InvoiceList }
];
