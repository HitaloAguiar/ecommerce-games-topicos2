import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CidadeRoutingModule } from './cidade-routing.module';
import { CidadeListComponent } from './components/cidade-list/cidade-list.component';
import { CidadeFormComponent } from './components/cidade-form/cidade-form.component';


@NgModule({
  declarations: [
    CidadeListComponent,
    CidadeFormComponent
  ],
  imports: [
    CommonModule,
    CidadeRoutingModule
  ]
})
export class CidadeModule { }
