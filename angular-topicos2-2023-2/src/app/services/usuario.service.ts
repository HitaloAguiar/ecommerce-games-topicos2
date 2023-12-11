import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario.model';
import { Endereco } from '../models/endereco.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.baseURL}/usuarios`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Usuario[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Usuario[]>(`${this.baseURL}/usuarios/paginado`, {params});
  }

  findById(id: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.baseURL}/usuarios/${id}`);
  }

  save(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.baseURL}/usuarios`, usuario);
  }

  update(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.baseURL}/usuarios/${usuario.id}`, usuario);
  }

  delete(usuario: Usuario): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/usuarios/${usuario.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Usuario[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Usuario[]>(`${this.baseURL}/usuarios/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/usuarios/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/usuarios/search/${nome}/count`);
  }

  getEndereco(idUsuario: string): Observable<Endereco> {
    return this.http.get<Endereco>(`${this.baseURL}/usuarios/${idUsuario}/endereco`);
  }

  salvarEndereco(endereco: Endereco, idUsuario: number): Observable<Endereco> {
    return this.http.post<Endereco>(`${this.baseURL}/usuarios/${idUsuario}/endereco`, endereco);
  }

  atualizarEndereco( idUsuario: number, endereco: Endereco): Observable<Endereco> {
    return this.http.put<Endereco>(`${this.baseURL}/usuarios/${idUsuario}/endereco`, endereco);
  }
}