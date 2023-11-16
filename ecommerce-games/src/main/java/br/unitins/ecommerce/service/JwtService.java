package br.unitins.ecommerce.service;

import br.unitins.ecommerce.dto.usuario.UsuarioResponseDTO;

public interface JwtService {
    public String generateJwt(UsuarioResponseDTO dto);
}
