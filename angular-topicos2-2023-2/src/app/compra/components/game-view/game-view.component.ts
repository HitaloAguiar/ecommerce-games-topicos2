import { Component, OnInit, signal } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Game } from 'src/app/models/game.model';
import { CarrinhoService } from 'src/app/services/carrinho.service';
import { GameService } from 'src/app/services/game.service';

@Component({
  selector: 'app-game-view',
  templateUrl: './game-view.component.html',
  styleUrls: ['./game-view.component.css']
})
export class GameViewComponent implements OnInit{
  game!: Game;

  constructor(private gameService: GameService, 
    private carrinhoService: CarrinhoService,
    private snackBar: MatSnackBar, 
    private router: Router,
    private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm() {

    this.game = this.activatedRoute.snapshot.data['game'];

  }

  images = [
    {
      src: 'https://images2.alphacoders.com/521/521477.jpg',
      alt: 'Imagem 1',
      link: 'https://www.example.com/image1'
    },
    {
      src: 'https://images2.alphacoders.com/130/1307306.png',
      alt: 'Imagem 2',
      link: 'https://www.example.com/image2'
    },
    {
      src: 'https://images4.alphacoders.com/463/46386.jpg',
      alt: 'Imagem 3',
      link: 'https://www.example.com/image3'
    }
  ];
  currentImageIndex = 0;

  onImageClick(imageIndex: number) {
    this.currentImageIndex = imageIndex;
  }

  prevImage() {
    this.currentImageIndex = (this.currentImageIndex - 1 + this.images.length) % this.images.length;
  }
  
  nextImage() {
    this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;
  }

}
