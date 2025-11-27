import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { Customer } from '../../../models/Customer';
import { CustomerService } from '../../../services/customer-service';

@Component({
  selector: 'app-customer-list',
  imports: [MatTableModule,MatCardModule],
  templateUrl: './customer-list.html',
  styleUrl: './customer-list.css',
})
export class CustomerList implements OnInit {
  customers: Customer[] = [];
  columns = ['id', 'name', 'email'];

  constructor(private cd: ChangeDetectorRef,private service: CustomerService) {}

  ngOnInit() {
    this.service.getCustomers().subscribe(data =>
      {
        this.customers = data
       this.cd.detectChanges();
    });
  }
}
