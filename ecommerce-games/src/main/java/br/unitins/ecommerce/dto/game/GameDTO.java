package br.unitins.ecommerce.dto.game;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GameDTO(
    
    @NotBlank(message = "O campo nome não pode estar nulo")
    @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.")
    String nome,

    String descricao,

    @NotNull(message = "O campo preco não pode estar nulo")
    @DecimalMin(value = "0")
    Double preco,

    @NotNull(message = "O campo anoLancamento não pode estar nulo")
    LocalDate anoLancamento,

    @NotNull(message = "Campo developer não pode estar vazio")
    Long developer,

    @NotNull(message = "Campo gêneros não pode estar vazio")
    List<Long> generos,

    @NotNull(message = "Campo plataformas não pode estar vazio")
    List<Long> plataformas
) {
    
}
