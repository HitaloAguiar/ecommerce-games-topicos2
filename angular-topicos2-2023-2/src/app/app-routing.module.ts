import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'estados', loadChildren: () => import('./estado/estado.module').then(m => m.EstadoModule)},
  {path: 'cidades', loadChildren: () => import('./cidade/cidade.module').then(m => m.CidadeModule)},
  {path: 'generos', loadChildren: () => import('./genero/genero.module').then(m => m.GeneroModule)},
  {path: 'developers', loadChildren: () => import('./developer/developer.module').then(m => m.DeveloperModule)},
  {path: 'fabricantes', loadChildren: () => import('./fabricante/fabricante.module').then(m => m.FabricanteModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
