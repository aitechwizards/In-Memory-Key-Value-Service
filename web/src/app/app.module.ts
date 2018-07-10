import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatListModule } from '@angular/material/list';

import { AppComponent } from './app.component';
import { KeyvalueComponent } from './keyvalue/index';
import { AuditComponent } from './audit/index';
import { AlertDirective } from './_directives/index';
import { routing } from './app.routing';
import { KeyvalueService } from './_services/keyvalue.service';
import { HttpModule } from '@angular/http';
import {MatTableModule} from '@angular/material/table'

@NgModule({

  imports: [
    BrowserModule,  HttpModule,   MatFormFieldModule,MatListModule,MatTableModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatToolbarModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    routing, FormsModule,
    BrowserAnimationsModule,
  ],
  declarations: [
    AppComponent,
    KeyvalueComponent,
    AuditComponent,
    AlertDirective
  ],
  providers: [KeyvalueService, HttpModule ],
  bootstrap: [AppComponent]
})
export class AppModule { }
