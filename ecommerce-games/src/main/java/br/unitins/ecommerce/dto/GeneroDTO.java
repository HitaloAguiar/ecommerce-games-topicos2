package br.unitins.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;

public record GeneroDTO (
    
    @NotBlank(message = "Campo nome não pode estar vazio")
    String nome
) {
    
}
