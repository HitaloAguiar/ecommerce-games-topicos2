package br.unitins.ecommerce.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlataformaDTO(
    
    @NotBlank(message = "Campo nome não pode estar vazio")
    String nome,

    @NotBlank(message = "Campo nome não pode estar vazio")
    String descricao,

    @NotBlank(message = "Campo anoLancamento não pode estar vazio")
    LocalDate anoLancamento,

    @NotNull
    @Min(1)
    Long fabricante
) {
    
}
