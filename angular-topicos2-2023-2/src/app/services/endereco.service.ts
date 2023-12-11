// endereco.service.ts
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Endereco } from '../models/endereco.model';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  private baseURL: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Endereco[]> {
    return this.http.get<Endereco[]>(`${this.baseURL}/enderecos`);
  }

  findById(id: string): Observable<Endereco> {
    return this.http.get<Endereco>(`${this.baseURL}/enderecos/${id}`);
  }

  save(endereco: Endereco): Observable<Endereco> {
    return this.http.post<Endereco>(`${this.baseURL}/enderecos`, endereco);
  }

  update(endereco: Endereco): Observable<Endereco> {
    return this.http.put<Endereco>(`${this.baseURL}/enderecos/${endereco.id}`, endereco);
  }

  delete(endereco: Endereco): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/enderecos/${endereco.id}`);
  }

}
