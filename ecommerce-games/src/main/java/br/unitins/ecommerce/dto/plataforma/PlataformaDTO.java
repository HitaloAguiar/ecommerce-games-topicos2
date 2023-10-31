package br.unitins.ecommerce.dto.plataforma;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PlataformaDTO(
    
    @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.")
    @NotBlank(message = "Campo nome não pode estar vazio")
    String nome,

    @NotBlank(message = "Campo descrição não pode estar vazio")
    String descricao,

    @NotNull(message = "Campo ano de Lançamento não pode estar vazio")
    LocalDate anoLancamento,

    @NotNull(message = "Campo fabricante não pode estar vazio")
    Long fabricante
) {
    
}
