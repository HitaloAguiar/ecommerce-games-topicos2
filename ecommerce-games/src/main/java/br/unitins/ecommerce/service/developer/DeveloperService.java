package br.unitins.ecommerce.service.developer;

import java.util.List;

import br.unitins.ecommerce.dto.developer.DeveloperDTO;
import br.unitins.ecommerce.dto.developer.DeveloperResponseDTO;
import jakarta.validation.Valid;

public interface DeveloperService {
    
    List<DeveloperResponseDTO> getAll();
    
    List<DeveloperResponseDTO> getAll(int page, int pageSize);
    
    DeveloperResponseDTO getById(Long id);

    DeveloperResponseDTO insert(@Valid DeveloperDTO developerDTO);

    DeveloperResponseDTO update(Long id, @Valid DeveloperDTO developerDTO);

    void delete(Long id);

    List<DeveloperResponseDTO> getByNome(String nome, int page, int pageSize);

    Long count();

    Long countByNome(String nome);
}
