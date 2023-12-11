import { Cidade } from "./cidade.model";

export class Endereco {
    id!: number
    logradouro!: string;
    bairro!: string;
    numero!: string;
    complemento!: String
    cep!: string;
    cidade!: Cidade
}