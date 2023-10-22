import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Game } from 'src/app/models/game.model';
import { GameService } from 'src/app/services/game.service';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {

  tableColumns: string[] = ['id-column', 'nome-column', 'ano-lancamento-column', 'developer-column', 'genero-column', 'plataforma-column', 'preco-column', 'acoes-column'];
  games: Game[] = [];

  totalRegistros = 0;
  pageSize = 2;
  pagina = 0;
  filtro: string = "";

  constructor(private gameService: GameService) {}

  ngOnInit(): void {

    this.carregarGames();
    this.carregarTotalRegistros();
  }

  carregarGames() {

    // se existe dados no filtro
    if (this.filtro) {
      this.gameService.findByNome(this.filtro, this.pagina, this.pageSize).subscribe(data => {
        this.games = data;
      });
    } else {
      // buscando todos os games
      this.gameService.findAllPaginado(this.pagina, this.pageSize).subscribe(data => {
        this.games = data;
      });
    }
  }

  carregarTotalRegistros() {
    // se existe dados no filtro
    if (this.filtro) {
      this.gameService.countByNome(this.filtro).subscribe(data => {
        this.totalRegistros = data;
      });
    } else {
      this.gameService.count().subscribe(data => {
        this.totalRegistros = data;
      });
    }
  }

  excluir(game: Game) {

      if (game.id != null) {

        this.gameService.delete(game).subscribe({
          next: (gameCadastrado) => {
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
    this.carregarGames();
  }

  aplicarFiltro() {
    this.carregarGames();
    this.carregarTotalRegistros();
  }
}
