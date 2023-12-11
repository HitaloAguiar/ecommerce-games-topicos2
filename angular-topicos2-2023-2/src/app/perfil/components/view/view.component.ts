import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Cidade } from 'src/app/models/cidade.model';
import { Endereco } from 'src/app/models/endereco.model';
import { Usuario } from 'src/app/models/usuario.model';
import { AuthService } from 'src/app/services/auth.service';
import { CidadeService } from 'src/app/services/cidade.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent {


  usuarioLogado: Usuario | null = null;
  private subscription = new Subscription();
  apiResponse: any = null;
  selecionado: 'conta' | 'historico' | 'endereco' = 'conta';
  formGroup: FormGroup;
  cidades: Cidade[] = [];

  constructor(private authService: AuthService,
    private formBuilder: FormBuilder,
    private router: Router,
    private usuarioService: UsuarioService,
    private activatedRoute: ActivatedRoute,
    private cidadeService: CidadeService) {
    const endereco: Endereco = this.activatedRoute.snapshot.data['endereco'];
    this.formGroup = formBuilder.group({
      logradouro: [(endereco && endereco.logradouro) ? endereco.logradouro : '', Validators.required],
      numero: [(endereco && endereco.numero) ? endereco.numero : '', Validators.required],
      complemento: [(endereco && endereco.complemento) ? endereco.complemento : ''],
      bairro: [(endereco && endereco.bairro) ? endereco.bairro : '', Validators.required],
      cep: [(endereco && endereco.cep) ? endereco.cep : '', Validators.required],
      cidade: [(endereco && endereco.cidade) ? endereco.cidade : '', Validators.required],
    });

  }
  ngOnInit(): void {
    this.cidadeService.findAll().subscribe((cidades: Cidade[]) => {
      this.cidades = cidades;
    this.obterUsuarioLogado();
  });
}



  editar() {
    if (this.usuarioLogado && this.usuarioLogado.id) {
      this.router.navigateByUrl(`perfil/update/${this.usuarioLogado.id}`);
    } else {
      console.error('ID do usuário não disponível.');
    }
  }


  obterUsuarioLogado() {
    this.subscription.add(this.authService.getUsuarioLogado().subscribe(
      usuario => this.usuarioLogado = usuario
    ));
  }

  salvar() {
    if (this.formGroup.valid) {
      const novoEndereco = this.formGroup.value;
      
      if (this.usuarioLogado && this.usuarioLogado.id) {
        novoEndereco.idUsuario = this.usuarioLogado.id; // Substitua 'idUsuario' pelo campo correto no seu modelo Endereco
  
        if (!novoEndereco.id) {
          this.usuarioService.salvarEndereco(novoEndereco, this.usuarioLogado.id).subscribe({
            next: (enderecoCadastrado) => {
              console.log('Endereço cadastrado com sucesso:', enderecoCadastrado);
            },
            error: (errorResponse) => {
              this.apiResponse = errorResponse.error;
              console.log('Erro ao cadastrar endereço:', errorResponse);
            }
          });
        } else {
          this.usuarioService.atualizarEndereco(this.usuarioLogado.id, novoEndereco).subscribe({
            next: (enderecoAtualizado) => {
              console.log('Endereço atualizado com sucesso:', enderecoAtualizado);
            },
            error: (errorResponse) => {
              this.apiResponse = errorResponse.error;
              console.log('Erro ao atualizar endereço:', errorResponse);
            }
          });
        }
      } else {
        console.error('ID do usuário não disponível.');
      }
    }
  }

  getErrorMessage(fieldName: string): string {
    const error = this.apiResponse.errors.find((error: any) => error.fieldName === fieldName);
    return error ? error.message : '';
  }
}