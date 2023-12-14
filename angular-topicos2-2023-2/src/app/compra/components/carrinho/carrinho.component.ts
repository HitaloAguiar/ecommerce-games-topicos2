// carrinho.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemCarrinho } from 'src/app/models/item-carrinho.interface';
import { AuthService } from 'src/app/services/auth.service';
import { CarrinhoService } from 'src/app/services/carrinho.service';
import { PedidoService } from 'src/app/services/pedido.service';
import { Subscription } from 'rxjs';
import { Usuario } from 'src/app/models/usuario.model';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from 'src/app/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css'],
})
export class CarrinhoComponent implements OnInit {
  
  carrinhoItens: ItemCarrinho[] = [];
  continuar: boolean = false;
  pagando: boolean = false;
  selectedOption: string = '';
  private subscription = new Subscription();
  usuarioLogado: Usuario | null = null;
  enderecoSelecionado: boolean = false;

  constructor(private carrinhoService: CarrinhoService,
    private router: Router,
    private pedidoService: PedidoService,
    private authService: AuthService,
    private dialog: MatDialog) { }

  ngOnInit(): void {
    this.carrinhoService.carrinho$.subscribe(itens => {
      this.carrinhoItens = itens;
    });
    this.obterUsuarioLogado();
    this.enderecoSelecionado = false;
  }

  selecionarEndereco() {
    this.enderecoSelecionado = !this.enderecoSelecionado;
    if (!this.enderecoSelecionado) {
      this.pagando = false;
    }
  }

  continuarCompra() {
    this.continuar = true;
  }

  terminarCompra() {
    this.continuar = false;
  }

  seguirParaPagamento() {
    this.pagando = true;
  }

  fecharPagamento() {
    this.pagando = false;
  }

  obterUsuarioLogado() {
    this.subscription.add(this.authService.getUsuarioLogado().subscribe(
      usuario => this.usuarioLogado = usuario
    ));
  }

  removerItem(item: ItemCarrinho): void {
    this.carrinhoService.remover(item);
  }

  calcularTotal(): number {
    return this.carrinhoItens.reduce((total, item) => total + item.quantidade * item.preco, 0);
  }

  finalizarCompra() {
    this.pedidoService.save(this.carrinhoItens).subscribe({
      next: () => {
        this.carrinhoService.removerTudo();
        this.router.navigateByUrl('/user/compras/produtos');
      },
      error: (err) => {
        console.log('Erro ao incluir' + JSON.stringify(err));
      }
    });
  }

  abrirDialogoConfirmacao(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
      data: { message: 'Tem certeza de que deseja editar o endereço?' }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        // Redirecionar para 'user/perfil/view' se o usuário confirmar
        this.redirecionarParaPerfil();
      }
    });
  }

  redirecionarParaPerfil(): void {
    this.router.navigate(['/user/perfil/view'], {
      queryParams: {
        selecionado: 'endereco',
        editandoEndereco: true
      }
    });
  }

}
