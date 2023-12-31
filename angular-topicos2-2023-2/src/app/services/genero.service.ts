import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Genero } from '../models/genero.model';

@Injectable({
  providedIn: 'root'
})
export class GeneroService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Genero[]> {
    return this.http.get<Genero[]>(`${this.baseURL}/generos`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Genero[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Genero[]>(`${this.baseURL}/generos/paginado`, {params});
  }

  findById(id: string): Observable<Genero> {
    return this.http.get<Genero>(`${this.baseURL}/generos/${id}`);
  }

  save(genero: Genero): Observable<Genero> {
    return this.http.post<Genero>(`${this.baseURL}/generos`, genero);
  }

  update(genero: Genero): Observable<Genero> {
    return this.http.put<Genero>(`${this.baseURL}/generos/${genero.id}`, genero);
  }

  delete(genero: Genero): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/generos/${genero.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Genero[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Genero[]>(`${this.baseURL}/generos/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/generos/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/generos/search/${nome}/count`);
  }
}
