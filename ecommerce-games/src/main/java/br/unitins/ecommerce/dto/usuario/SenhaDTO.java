package br.unitins.ecommerce.dto.usuario;

public record SenhaDTO(
    String senhaAntiga,
    String novaSenha,
    String confirmarNovaSenha
) {
    
}
