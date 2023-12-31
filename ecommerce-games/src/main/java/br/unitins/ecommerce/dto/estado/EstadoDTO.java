package br.unitins.ecommerce.dto.estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record EstadoDTO(
    @NotBlank(message = "Campo nome não pode estar vazio")
    @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.")
    String nome,

    @NotBlank(message = "Campo sigla não pode estar vazio")
    @Size(max = 2, min = 2, message = "a sigla é composta por extamente duas letras")
    String sigla
) {
    
}
