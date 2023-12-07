package br.unitins.ecommerce.service.usuario;

import java.util.List;

import br.unitins.ecommerce.dto.usuario.UsuarioDTO;
import br.unitins.ecommerce.dto.usuario.UsuarioResponseDTO;
import br.unitins.ecommerce.model.usuario.Usuario;
import jakarta.validation.Valid;

public interface UsuarioService {
    
    List<UsuarioResponseDTO> getAll();
    
    List<UsuarioResponseDTO> getAll(int page, int pageSize);

    UsuarioResponseDTO getById(Long id);

    UsuarioResponseDTO insert(@Valid UsuarioDTO usuarioDto);

    UsuarioResponseDTO update(Long id, @Valid UsuarioDTO usuarioDto);

    void delete(Long id);

    List<UsuarioResponseDTO> getByNome(String nome, int page, int pageSize);

    public Usuario findByLoginAndSenha(String login, String senha);
    
    Long count();

    Long countByNome(String nome);
}
