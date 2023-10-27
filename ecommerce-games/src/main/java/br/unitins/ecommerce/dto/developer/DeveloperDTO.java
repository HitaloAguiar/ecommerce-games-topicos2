package br.unitins.ecommerce.dto.developer;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record DeveloperDTO(

    @NotBlank(message = "Campo nome não pode estar vazio")
    @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.")
    String nome,

    @NotNull(message = "Campo anoFundacao não pode estar vazio")
    @PastOrPresent
    LocalDate anoFundacao,

    @NotNull
    String classificacao
) {
    
}
