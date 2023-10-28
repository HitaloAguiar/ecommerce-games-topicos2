package br.unitins.ecommerce.service.noticia;

import java.util.List;
import jakarta.validation.Valid;
import br.unitins.ecommerce.dto.noticia.NoticiaDTO;
import br.unitins.ecommerce.dto.noticia.NoticiaResponseDTO;

public interface NoticiaService {
    
    List<NoticiaResponseDTO> getAll();
    
    List<NoticiaResponseDTO> getAll(int page, int pageSize);
    
    NoticiaResponseDTO getById(Long id);

    NoticiaResponseDTO insert(@Valid NoticiaDTO noticiaDTO);

    NoticiaResponseDTO update(Long id, @Valid NoticiaDTO noticiaDTO);

    void delete(Long id);

    List<NoticiaResponseDTO> getByTitulo(String nome, int page, int pageSize);

    Long count();

    Long countByTitulo(String nome);
}
