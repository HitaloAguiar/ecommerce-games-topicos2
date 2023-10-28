package br.unitins.ecommerce.dto.noticia;

import java.time.LocalDate;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NoticiaDTO(

    @NotBlank(message = "O campo titulo não pode estar nulo")
    @Size(max = 60, message = "O campo titulo deve possuir no máximo 120 caracteres.")
    String titulo,

    @NotBlank(message = "O campo conteudo não pode estar nulo")
    String conteudo,

    @NotBlank(message = "O campo autor não pode estar nulo")
    @Size(max = 60, message = "O campo autor deve possuir no máximo 60 caracteres.")
    String autor,

    @NotNull(message = "Campo dataPublicacao não pode estar vazio")
    @PastOrPresent
    LocalDate dataPublicacao,

    @NotNull
    String topicoPrincipal
) {
    
}
