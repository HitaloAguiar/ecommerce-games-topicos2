package br.unitins.ecommerce.service.genero;

import java.util.List;

import br.unitins.ecommerce.dto.genero.GeneroDTO;
import br.unitins.ecommerce.dto.genero.GeneroResponseDTO;

public interface GeneroService {
    
    List<GeneroResponseDTO> getAll();
    
    List<GeneroResponseDTO> getAll(int page, int pageSize);
    
    GeneroResponseDTO getById(Long id);

    GeneroResponseDTO insert(GeneroDTO generoDTO);

    GeneroResponseDTO update(Long id, GeneroDTO generoDTO);

    void delete(Long id);

    List<GeneroResponseDTO> getByNome(String nome, int page, int pageSize);

    Long count();

    Long countByNome(String nome);
}
