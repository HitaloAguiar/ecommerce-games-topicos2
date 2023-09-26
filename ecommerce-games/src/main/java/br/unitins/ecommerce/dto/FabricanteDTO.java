package br.unitins.ecommerce.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record FabricanteDTO(

    @NotBlank(message = "Campo nome não pode estar vazio")
    String nome,

    @NotBlank(message = "Campo anoFundacao não pode estar vazio")
    LocalDate anoFundacao
) {
    
}
