package br.unitins.ecommerce.service.usuario;

import java.util.List;
import java.util.Set;

import br.unitins.ecommerce.dto.usuario.UsuarioDTO;
import br.unitins.ecommerce.dto.usuario.UsuarioResponseDTO;
import br.unitins.ecommerce.model.usuario.Perfil;
import br.unitins.ecommerce.model.usuario.Telefone;
import br.unitins.ecommerce.model.usuario.Usuario;
import br.unitins.ecommerce.repository.UsuarioRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioImplService implements UsuarioService {

    @Inject
    Validator validator;

    @Inject
    UsuarioRepository usuarioRepository;

    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<UsuarioResponseDTO> getAll() {
        
        return usuarioRepository.findAll(sort).stream().map(usuario -> new UsuarioResponseDTO(usuario, null)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> getAll(int page, int pageSize) {
        
        return usuarioRepository.findAll(sort).page(page, pageSize).stream().map(usuario -> new UsuarioResponseDTO(usuario, null)).toList();
    }

    @Override
    public UsuarioResponseDTO getById(Long id) {
        
        Usuario usuario = usuarioRepository.findById(id);

        if (usuario == null)
            throw new NotFoundException("Não encontrado");

        return new UsuarioResponseDTO(usuario, usuario.getPerfil().toString());
    }

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO usuarioDto) throws ConstraintViolationException {
        
        validar(usuarioDto);

        Usuario entity = new Usuario();

        entity.setNome(usuarioDto.nome());

        entity.setCpf(usuarioDto.cpf());

        entity.setEmail(usuarioDto.email());

        entity.setLogin(usuarioDto.login());

        entity.setSenha(usuarioDto.senha());

        entity.setPerfil(Perfil.valueOf(usuarioDto.perfil()));

        for (String telefone : usuarioDto.telefones()) {
            
            entity.getTelefones().add(new Telefone(telefone));
        }

        usuarioRepository.persist(entity);

        return new UsuarioResponseDTO(entity, null);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, @Valid UsuarioDTO usuarioDto) throws ConstraintViolationException {
        
        validar(usuarioDto);

        Usuario entity = usuarioRepository.findById(id);

        if (entity == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        entity.setNome(usuarioDto.nome());

        entity.setCpf(usuarioDto.cpf());

        entity.setEmail(usuarioDto.email());

        entity.setLogin(usuarioDto.login());

        entity.setSenha(usuarioDto.senha());

        entity.setPerfil(Perfil.valueOf(usuarioDto.perfil()));

        // for (Telefone telefone : entity.getTelefones()) {
            
        //     entity.getTelefones().remove(telefone);
        // }

        entity.getTelefones().clear();

        for (String telefones : usuarioDto.telefones()) {
            
            entity.getTelefones().add(new Telefone(telefones));
        }

        return new UsuarioResponseDTO(entity, null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Usuario usuario = usuarioRepository.findById(id);

        if (usuarioRepository.isPersistent(usuario))
            usuarioRepository.delete(usuario);

        else
            throw new NotFoundException("Nenhum usuario encontrado");
    }

    @Override
    public List<UsuarioResponseDTO> getByNome(String nome, int page, int pageSize) {
        
        return usuarioRepository.findByNome(nome, sort).page(page, pageSize).stream().map(usuario -> new UsuarioResponseDTO(usuario, null)).toList();        
    }

    @Override
    public Long count() {

        return usuarioRepository.count();
    }

    @Override
    public Long countByNome(String nome) {

        return usuarioRepository.findByNome(nome, sort).count();
    }
    
    private void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLoginAndSenha(login, senha);
        return UsuarioResponseDTO.valueOf(usuario);
    }
}
