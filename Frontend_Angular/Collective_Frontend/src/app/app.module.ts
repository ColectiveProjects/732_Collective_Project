import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {UserModule} from "./user/user.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CoreModule} from "./core/core.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {CategoryComponent} from "./category/category/category.component";
import {TaskModule} from "./task/task.module";
import {CategoryModule} from "./category/category.module";
import {SidenavModule} from "./sidenav/sidenav.module";
import {HomeModule} from "./home/home.module";

@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        CoreModule,
        HttpClientModule,
        FormsModule,
        AppRoutingModule,
        UserModule,
        TaskModule,
        CategoryModule,
        SidenavModule,
        HomeModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
