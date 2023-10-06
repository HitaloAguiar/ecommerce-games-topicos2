package br.unitins.ecommerce.service.genero;

import java.util.List;

import br.unitins.ecommerce.dto.genero.GeneroDTO;
import br.unitins.ecommerce.dto.genero.GeneroResponseDTO;

public interface GeneroService {
    
    List<GeneroResponseDTO> getAll();
    
    GeneroResponseDTO getById(Long id);

    GeneroResponseDTO insert(GeneroDTO generoDTO);

    GeneroResponseDTO update(Long id, GeneroDTO generoDTO);

    void delete(Long id);
}
