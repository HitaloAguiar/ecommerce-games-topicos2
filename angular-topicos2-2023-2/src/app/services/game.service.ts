import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Game } from '../models/game.model';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.baseURL}/games`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Game[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Game[]>(`${this.baseURL}/games/paginado`, {params});
  }

  findById(id: string): Observable<Game> {
    return this.http.get<Game>(`${this.baseURL}/games/${id}`);
  }

  save(game: Game): Observable<Game> {
    return this.http.post<Game>(`${this.baseURL}/games`, game);
  }

  update(game: Game): Observable<Game> {
    return this.http.put<Game>(`${this.baseURL}/games/${game.id}`, game);
  }

  delete(game: Game): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/games/${game.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Game[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Game[]>(`${this.baseURL}/games/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/games/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/games/search/${nome}/count`);
  }

  getUrlImagem(nomeImagem: string): string {
    return `${this.baseURL}/games/image/download/${nomeImagem}`;
  }
}
