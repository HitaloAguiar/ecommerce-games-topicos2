import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Plataforma } from 'src/app/models/plataforma.model';
import { PlataformaService } from 'src/app/services/plataforma.service';

@Component({
  selector: 'app-plataforma-list',
  templateUrl: './plataforma-list.component.html',
  styleUrls: ['./plataforma-list.component.css']
})
export class PlataformaListComponent implements OnInit {

  tableColumns: string[] = ['id-column', 'nome-column','ano-lancamento-column','fabricante-column','acoes-column'];
  plataformas: Plataforma[] = [];

  totalRegistros = 0;
  pageSize = 2;
  pagina = 0;
  filtro: string = "";

  constructor(private plataformaService: PlataformaService) {}

  ngOnInit(): void {

    this.carregarPlataformas();
    this.carregarTotalRegistros();
  }

  carregarPlataformas() {

    // se existe dados no filtro
    if (this.filtro) {
      this.plataformaService.findByNome(this.filtro, this.pagina, this.pageSize).subscribe(data => {
        this.plataformas = data;
      });
    } else {
      // buscando todas as plataformas
      this.plataformaService.findAllPaginado(this.pagina, this.pageSize).subscribe(data => {
        this.plataformas = data;
      });
    }
  }

  carregarTotalRegistros() {
    // se existe dados no filtro
    if (this.filtro) {
      this.plataformaService.countByNome(this.filtro).subscribe(data => {
        this.totalRegistros = data;
      });
    } else {
      this.plataformaService.count().subscribe(data => {
        this.totalRegistros = data;
      });
    }
  }

  excluir(plataforma: Plataforma) {

      if (plataforma.id != null) {

        this.plataformaService.delete(plataforma).subscribe({
          next: (plataformaCadastrada) => {
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
    this.carregarPlataformas();
  }

  aplicarFiltro() {
    this.carregarPlataformas();
    this.carregarTotalRegistros();
  }
}
