import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/components/login/login.component';
import { AdminTemplateComponent } from './shared/components/admin-template/admin-template.component';
import { EstadoFormComponent } from './estado/components/estado-form/estado-form.component';
import { UserTemplateComponent } from './shared/components/user-template/user-template.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdminTemplateComponent, },
  {path: 'user',component: UserTemplateComponent,children: [
        // { path: 'register', component: RegisterComponent },
      ],
    },
    //{ path: '', redirectTo: '/user', pathMatch: 'full' }, // Rota padrão
    // { path: '**', redirectTo: '/user' }, // Rota para tratamento de erro



  {path: 'estados', loadChildren: () => import('./estado/estado.module').then(m => m.EstadoModule)},
  {path: 'cidades', loadChildren: () => import('./cidade/cidade.module').then(m => m.CidadeModule)},
  {path: 'generos', loadChildren: () => import('./genero/genero.module').then(m => m.GeneroModule)},
  {path: 'developers', loadChildren: () => import('./developer/developer.module').then(m => m.DeveloperModule)},
  {path: 'fabricantes', loadChildren: () => import('./fabricante/fabricante.module').then(m => m.FabricanteModule)},
  {path: 'plataformas', loadChildren: () => import('./plataforma/plataforma.module').then(m => m.PlataformaModule)},
  {path: 'games', loadChildren: () => import('./game/game.module').then(m => m.GameModule)},
  {path: 'noticias', loadChildren: () => import('./noticia/noticia.module').then(m => m.NoticiaModule)},
  {path: 'usuarios', loadChildren: () => import('./usuario/usuario.module').then(m => m.UsuarioModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
