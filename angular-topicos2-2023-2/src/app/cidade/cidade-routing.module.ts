import { cidadeResolver } from './../../../../../Project_ecommerce-main/angular-topicos2-2023-2/src/app/cidade/resolver/cidade-resolver';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CidadeListComponent } from './components/cidade-list/cidade-list.component';
import { CidadeFormComponent } from './components/cidade-form/cidade-form.component';

const routes: Routes = [
  {path: 'list', component: CidadeListComponent},
  {path: 'new', component: CidadeFormComponent},
  {path: 'edit/:id', component: CidadeFormComponent, resolve: {cidade: cidadeResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CidadeRoutingModule { }
