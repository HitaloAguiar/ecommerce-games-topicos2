package br.unitins.ecommerce.dto.usuario;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
    @NotBlank(message = "O campo nome não pode estar nulo")
    @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.")
    String nome,

    @NotBlank(message = "O campo CPF não pode estar nulo")
    String cpf,

    @NotBlank(message = "O campo email não pode estar nulo")
    String email,

    @NotBlank(message = "O campo login não pode estar nulo")
    String login,

    @NotBlank(message = "O campo senha não pode estar nulo")
    String senha,

    @NotBlank
    String perfil,

    List<String> telefones
) {
    
}
