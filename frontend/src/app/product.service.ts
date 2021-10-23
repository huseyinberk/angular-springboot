import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  apiUrl = environment.apiUrl + "product";

  getProducts():Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  getProduct(product:Product):Observable<Product> {
    return this.http.get<Product>(this.apiUrl + "/" + product.id);
  }

  createProduct(product : Product):Observable<Product> {
    return this.http.post<Product>(this.apiUrl , product);
  }

  deleteProduct(product : Product):Observable<Product> {
    return this.http.delete<Product>(this.apiUrl + "/" + product.id);
  }

  editProduct(product : Product):Observable<Product> {
    return this.http.put<Product>(this.apiUrl , product )
  }




}
