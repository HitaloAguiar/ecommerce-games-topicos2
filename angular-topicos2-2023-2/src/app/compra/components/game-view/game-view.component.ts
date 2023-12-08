import { Component, OnInit, signal } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Game } from 'src/app/models/game.model';
import { CarrinhoService } from 'src/app/services/carrinho.service';
import { GameService } from 'src/app/services/game.service';

type Card = {
  id: number;
  titulo: string;
  developer: string;
  preco: number;
  urlImagem: string;
}

@Component({
  selector: 'app-game-view',
  templateUrl: './game-view.component.html',
  styleUrls: ['./game-view.component.css']
})
export class GameViewComponent implements OnInit {
  game!: Game;
  cards = signal<Card[]>([]);
  games: Game[] = [];
  private gameService: GameService;

  images: { src: string; alt: string; link: string }[] = [];
  currentImageIndex = 0;

  getImageUrl(): string {
    return this.gameService.getUrlImagem(this.game.nomeImagem);
  }

  constructor(gameService: GameService,
    private carrinhoService: CarrinhoService,
    private snackBar: MatSnackBar,
    private router: Router,
    private activatedRoute: ActivatedRoute) { this.gameService = gameService; }

  ngOnInit(): void {
    this.carregarGames();
    this.initializeForm();
    this.carregarImagensCarousel();
  }

  carregarGames() {

    this.gameService.findAll().subscribe(data => {
      this.games = data;

      this.carregarCards();
    });
  }

  initializeForm() {
    this.game = this.activatedRoute.snapshot.data['game'];

  }

  carregarImagensCarousel() {
    if (this.game.nomeImagem1) {
      this.images.push({
        src: this.gameService.getUrlImagem(this.game.nomeImagem1),
        alt: 'Imagem 1',
        link: 'https://www.example.com/image1'
      });
    }

    if (this.game.nomeImagem2) {
      this.images.push({
        src: this.gameService.getUrlImagem(this.game.nomeImagem2),
        alt: 'Imagem 2',
        link: 'https://www.example.com/image2'
      });
    }

    if (this.game.nomeImagem3) {
      this.images.push({
        src: this.gameService.getUrlImagem(this.game.nomeImagem3),
        alt: 'Imagem 3',
        link: 'https://www.example.com/image3'
      });
    }
  }

  onImageClick(imageIndex: number) {
    this.currentImageIndex = imageIndex;
  }

  prevImage() {
    if (this.images.length > 0) {
      this.currentImageIndex = (this.currentImageIndex - 1 + this.images.length) % this.images.length;
    }
  }

  nextImage() {
    if (this.images.length > 0) {
      this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;
    }
  }

  carregarCards() {
    const cards: Card[] = [];
    this.games.forEach(game => {
      cards.push({
        id: game.id,
        titulo: game.nome,
        developer: game.developer.nome,
        preco: game.preco,
        urlImagem: this.gameService.getUrlImagem(game.nomeImagem)
      });
    });
    this.cards.set(cards);
  }

  adicionarAoCarrinho(card: Card): void {
    this.showSnackbarTopPosition('Produto adicionado ao carrinho!', 'Fechar');
    this.carrinhoService.adicionar({
      id: 1,
      nome: card.titulo,
      preco: card.preco,
      quantidade: 1,
      urlImagem: card.urlImagem,
    });
  }

  criarCard(jogo: Game): Card {
    return {
      id: jogo.id,
      titulo: jogo.nome,
      developer: jogo.developer.nome,
      preco: jogo.preco,
      urlImagem: this.gameService.getUrlImagem(jogo.nomeImagem)
    };
  }

  showSnackbarTopPosition(content: any, action: any) {
    this.snackBar.open(content, action, {
      duration: 2000,
      verticalPosition: "top", // Allowed values are  'top' | 'bottom'
      horizontalPosition: "center" // Allowed values are 'start' | 'center' | 'end' | 'left' | 'right'
    });
  }

}

