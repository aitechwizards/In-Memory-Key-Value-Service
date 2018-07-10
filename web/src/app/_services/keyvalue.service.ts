import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map'
import { Customer } from '../keyvalue';

@Injectable()
export class KeyvalueService {

  private actionUrl: string;
  public Server = 'http://localhost:9090/';
  public ApiUrl = 'inmemory/api/techwizards/doc/';
  public ServerWithApiUrl = this.Server + this.ApiUrl;
  constructor(private http: Http) {
  }
  getCustomerAll(): Observable<Customer[]> {
    console.log(this.ServerWithApiUrl)
    return this.http.get(this.ServerWithApiUrl)
      .map(this.extractData)
      .catch(this.handleError);

  }

  createCustomer(customer: Customer): Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.ServerWithApiUrl, customer, options)
      .map(success => success.status)
      .catch(this.handleError);
  }

  getCustomerById(keyId: string): Observable<Customer> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    console.log(this.ServerWithApiUrl + "/" + keyId);
    return this.http.get(this.ServerWithApiUrl + "/" + keyId)
      .map(this.extractData)
      .catch(this.handleError);
  }

  updateCustomer(customer: Customer): Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.ServerWithApiUrl, customer, options)
      .map(success => success.status)
      .catch(this.handleError);
  }


  deleteCustomerById(keyId: string): Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.actionUrl + "/" + keyId)
      .map(success => success.status)
    // .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body;
  }
  private handleError(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }
}