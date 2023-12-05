import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CarrinhoComponent } from './components/carrinho/carrinho.component';
import { CompraRoutingModule } from './compra-routing.module';

import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';


import { MatTableModule } from '@angular/material/table';
import { MatSelectModule } from '@angular/material/select';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';

import { ReactiveFormsModule } from '@angular/forms';

import { MatIconModule } from '@angular/material/icon';

import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_DATE_LOCALE, MatNativeDateModule } from '@angular/material/core';

import { MatListModule } from '@angular/material/list';
import { CustomPaginatorIntl } from 'src/app/models/custom-paginator-intl';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule } from '@angular/forms';
import { GameCardListComponent } from './components/game-card-list/game-card-list.component';

@NgModule({
  declarations: [
    CarrinhoComponent,
    GameCardListComponent
  ],
  imports: [
    CommonModule,
    CompraRoutingModule,
    MatDialogModule,
    MatSelectModule,
    MatToolbarModule,
    MatCardModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatListModule,
    MatPaginatorModule,
    FormsModule
  ]
})
export class CompraModule { }
