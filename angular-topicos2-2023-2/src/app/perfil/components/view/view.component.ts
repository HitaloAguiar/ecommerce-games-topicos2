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

  mostrarBotaoAdicionar: boolean = false;
  usuarioLogado: Usuario | null = null;
  private subscription = new Subscription();
  apiResponse: any = null;
  selecionado: 'Informacoes do Usuario' | 'historico' | 'endereco' | 'senha' = 'Informacoes do Usuario';
  formGroup: FormGroup;
  cidades: Cidade[] = [];

  selecionado2: string = 'Informacoes do Usuario'; // Pode ser inicializado com o valor padrão
  editandoEndereco: boolean = false;

  fileName: string = '';
  selectedFile: File | null = null;
  imagePreview: string | ArrayBuffer | null = null;

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
      cidade: [(endereco && endereco.cidade) ? endereco.cidade.id : '', Validators.required],
      // idUsuario: 0
    });

  }
  ngOnInit(): void {
    this.cidadeService.findAll().subscribe((cidades: Cidade[]) => {
      this.cidades = cidades;
      this.obterUsuarioLogado();
    });
  }

  editarEndereco() {
    this.editandoEndereco = true;
  }

  cancelarEdicaoEndereco() {
    this.editandoEndereco = false;
  }

  editar() {
    if (this.usuarioLogado && this.usuarioLogado.id) {
      if (this.usuarioLogado.perfil == 'ADMIN') {
        this.router.navigateByUrl(`/admin/perfil/update/${this.usuarioLogado.id}`);
      } else if (this.usuarioLogado.perfil == 'USER') {
        this.router.navigateByUrl(`/user/perfil/update/${this.usuarioLogado.id}`);
      }
    } else {
      console.error('ID do usuário não disponível.');
    }
  }

  inserirImagem() {
    // Lógica para inserir a imagem
    console.log('Inserir imagem!');
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
        // novoEndereco.idUsuario = this.usuarioLogado.id; // Substitua 'idUsuario' pelo campo correto no seu modelo Endereco

        if (!novoEndereco.id) {
          this.usuarioService.salvarEndereco(novoEndereco, this.usuarioLogado.id).subscribe({
            next: (usuarioAtualizado) => {
              console.log('Endereço do usuário cadastrado com sucesso:', usuarioAtualizado);
              this.authService.updateUsuarioLogado(usuarioAtualizado);
            },
            error: (errorResponse) => {
              this.apiResponse = errorResponse.error;
              console.log('Erro ao cadastrar endereço:', errorResponse);
            }
          });
        } else {
          this.usuarioService.atualizarEndereco(this.usuarioLogado.id, novoEndereco).subscribe({
            next: (usuarioAtualizado) => {
              console.log('Endereço do usuário atualizado com sucesso:', usuarioAtualizado);
              this.authService.updateUsuarioLogado(usuarioAtualizado);
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

    this.cancelarEdicaoEndereco();
  }

  getErrorMessage(fieldName: string): string {
    const error = this.apiResponse.errors.find((error: any) => error.fieldName === fieldName);
    return error ? error.message : '';
  }

  private uploadImage(faixaId: number) {

    if (this.selectedFile) {
      this.usuarioService.uploadImagem(faixaId, this.selectedFile.name, this.selectedFile)
        .subscribe({
          next: () => {
            this.router.navigateByUrl('/admin/games/list');
          },
          error: err => {
            console.log('Erro ao fazer o upload da imagem');
            // tratar o erro
          }
        })
    } else {
      this.router.navigateByUrl('/admin/games/list');
    }
  }

  carregarImagemSelecionada(event: any) {

    this.selectedFile = event.target.files[0];

    if (this.selectedFile) {
      this.fileName = this.selectedFile.name;
      // carregando image preview
      const reader = new FileReader();
      reader.onload = e => this.imagePreview = reader.result;
      reader.readAsDataURL(this.selectedFile);
    }
  }
}
