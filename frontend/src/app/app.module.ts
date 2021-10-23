import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService} from 'primeng/api';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { ProductService } from './product.service';
import {DialogModule} from 'primeng/dialog';
import { FormsModule } from '@angular/forms';

import {InputTextModule} from 'primeng/inputtext';
@NgModule({
  declarations: [ //componentler
    AppComponent,
    ProductListComponent
  ],
  imports: [ //moduller
    BrowserModule,
    AppRoutingModule,
    TableModule,
    ButtonModule,
    ConfirmDialogModule,
    BrowserAnimationsModule,
    HttpClientModule,
    DialogModule,
    FormsModule,
    InputTextModule
    
    
  ],
  providers: [ConfirmationService , ProductService , HttpClient], //servisler
  bootstrap: [ProductListComponent ] //AppComponent  //uygulamanın ilk ayaklandığı yer
})
export class AppModule { }
