package br.unitins.ecommerce.service.developer;

import java.util.List;

import br.unitins.ecommerce.dto.DeveloperDTO;
import br.unitins.ecommerce.model.produto.Developer;

public interface DeveloperService {
    
    List<Developer> getAll();
    
    Developer getById(Long id);

    Developer insert(DeveloperDTO developerDTO);

    Developer update(Long id, DeveloperDTO developerDTO);

    void delete(Long id);
}
