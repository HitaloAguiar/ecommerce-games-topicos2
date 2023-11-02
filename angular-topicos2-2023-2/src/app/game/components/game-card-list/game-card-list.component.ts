import { Component, OnInit, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Game } from 'src/app/models/game.model';
import { GameService } from 'src/app/services/game.service';

type Card = {
  titulo: string;
  developer: string;
  preco: number;
  urlImagem: string;
}

@Component({
  selector: 'app-game-card-list',
  templateUrl: './game-card-list.component.html',
  styleUrls: ['./game-card-list.component.css']
})
export class GameCardListComponent implements OnInit {

  cards = signal<Card[]> ([]);
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

    if (this.filtro) {
      this.gameService.findByNome(this.filtro, this.pagina, this.pageSize).subscribe(data => {
        this.games = data;
        this.carregarCards();
      });
    } else {
      // buscando todos os games
      this.gameService.findAllPaginado(this.pagina, this.pageSize).subscribe(data => {
        this.games = data;
        this.carregarCards();
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

  carregarCards() {
    const cards: Card[] = [];
    this.games.forEach(game => {
      cards.push({
        titulo: game.nome,
        developer: game.developer.nome,
        preco: game.preco,
        urlImagem: this.gameService.getUrlImagem(game.nomeImagem)
      });
    });
    this.cards.set(cards);
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
