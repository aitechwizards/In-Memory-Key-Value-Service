import { Component, OnInit } from '@angular/core';
import { KeyvalueService } from '../_services/keyvalue.service';

@Component({
  selector: 'app-keyvalue',
  templateUrl: './keyvalue.component.html',
  styleUrls: ['./keyvalue.component.css']
})
export class KeyvalueComponent implements OnInit {
  customer = new Customer();
  statusCode: number;
  public customers: Customer[];
  constructor(private keyValueService: KeyvalueService) {
  }
  ngOnInit() {
    this.fetchAllCustomers()
  }
  fetchAllCustomers() {
    this.keyValueService.getCustomerAll().subscribe(
      data => this.customers = data);
  }


  addKeyValue(cust: Customer) {
    console.log("Invoked: addKeyValue", this.customer);
    this.keyValueService.createCustomer(cust)
      .subscribe(successCode => {
        this.fetchAllCustomers();
      }
      );
    console.log("Exit: addKeyValue", this.customer)
    this.customer=new Customer();
  };


  updateCustomer(cust: Customer) {
    console.log("Update ", cust)
    this.customer = cust


    this.keyValueService.updateCustomer(cust)
      .subscribe(successCode => {
        this.fetchAllCustomers();
      },
        errorCode => this.statusCode = errorCode);
  }

  //Delete Customer
  deleteArticle(keyId: string) {
    this.keyValueService.deleteCustomerById(keyId)
      .subscribe(successCode => {
        console.log("Exit: deleteCustomer", keyId)

      });

  }

  displayedColumns: string[] = ['keyId', 'fullName','Action']; 
}

export class Customer {
  public keyId: number;
  public fullName: string

}
