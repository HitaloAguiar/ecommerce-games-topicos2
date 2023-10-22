import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Cidade } from 'src/app/models/cidade.model';
import { CidadeService } from 'src/app/services/cidade.service';

@Component({
  selector: 'app-cidade-list',
  templateUrl: './cidade-list.component.html',
  styleUrls: ['./cidade-list.component.css']
})
export class CidadeListComponent implements OnInit {

  tableColumns: string[] = ['id-column', 'nome-column', 'estado-column', 'acoes-column'];
  cidades: Cidade[] = [];

  totalRegistros = 0;
  pageSize = 2;
  pagina = 0;
  filtro: string = "";

  constructor(private cidadeService: CidadeService) {}

  ngOnInit(): void {

    this.carregarCidades();
    this.carregarTotalRegistros();
  }

  carregarCidades() {

    // se existe dados no filtro
    if (this.filtro) {
      this.cidadeService.findByNome(this.filtro, this.pagina, this.pageSize).subscribe(data => {
        this.cidades = data;
      });
    } else {
      // buscando todos os cidades
      this.cidadeService.findAllPaginado(this.pagina, this.pageSize).subscribe(data => {
        this.cidades = data;
      });
    }
  }

  carregarTotalRegistros() {
    // se existe dados no filtro
    if (this.filtro) {
      this.cidadeService.countByNome(this.filtro).subscribe(data => {
        this.totalRegistros = data;
      });
    } else {
      this.cidadeService.count().subscribe(data => {
        this.totalRegistros = data;
      });
    }
  }

  excluir(cidade: Cidade) {

    if (cidade.id != null) {

      this.cidadeService.delete(cidade).subscribe({
        next: (cidadeCadastrado) => {
          this.ngOnInit();
        },
        error: (err) => {
          console.log('Erro ao excluir' + JSON.stringify(err));
        }
      })
    }
  }

  // Método para paginar os resultados
  paginar(event: PageEvent): void {
    this.pagina = event.pageIndex;
    this.pageSize = event.pageSize;
    this.carregarCidades();
  }

  aplicarFiltro() {
    this.carregarCidades();
    this.carregarTotalRegistros();
  }
}
