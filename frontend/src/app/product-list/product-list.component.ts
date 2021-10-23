import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { MockProducts } from '../mock-products';
import {ConfirmationService} from 'primeng/api';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  // providers: [ConfirmationService]
})
export class ProductListComponent implements OnInit {

  products : Product[];
  product : Product;
  productDialogVisible : boolean;
  submitted: boolean;
  //products = MockProducts;

  // constructor() { 
  //   //  this.products = [{id : 12 , name : "lala" , price : 12 , imageUrl : "6556"}] 
  // }
  
  constructor(private confirmationService: ConfirmationService , private productService:ProductService) {
    this.products = [] 
    this.product = {}
    this.productDialogVisible = false;
    this.submitted = false;
  }

  ngOnInit(): void {
    this.getProducts();
    
  }

  getProducts(): void{
    this.productService.getProducts().subscribe(data=>this.products=data)
  }

  addProduct(): void{
    // let addProduct:Product = {id:0 , name : "bebebebe" , price : 5};
    // this.productDialogVisible = true;
    // this.productService.createProduct(addProduct).subscribe()
    // alert("add product");
    // this.getProducts();
    this.openProductForm({});
  }

  deleteProduct(product : Product) : void{
    this.confirmationService.confirm({
      message: 'Are you sure that you want to perform this action?',
      accept: () => {
          this.productService.deleteProduct(product).subscribe(() => console.log(product.id)) 
          alert("deleted" + product.id)
          this.getProducts();
      }
  });
  }
  editProduct(product : Product) : void{
    // this.product.id = 0;
    // this.product.name = "aaa";
    // this.product.imageUrl = "jksdkds";
    // this.product.price = 10;
    // this.productService.editProduct(product).subscribe(() => console.log(product.id)) 
    // alert("edit");
    this.openProductForm(product);
  }

  openProductForm(p:Product){ //anlamadım
    this.product = {...p}; //product adaki verileri boş ya da dolu getirir
    this.productDialogVisible = true;
    this.submitted = false;
  }

  saveProduct(){
    this.submitted  = true;
    if(this.product.id && this.product.id > 0){
      this.productService.editProduct(this.product).subscribe(() => this.getProducts()); 
      // nasıl buradaki product this product olyot -- ngModel
    }else{
      this.productService.createProduct(this.product).subscribe(() => this.getProducts());
    }
  }

  
  

}
