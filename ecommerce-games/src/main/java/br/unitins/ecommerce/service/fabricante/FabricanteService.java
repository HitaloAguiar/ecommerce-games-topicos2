package br.unitins.ecommerce.service.fabricante;

import java.util.List;

import br.unitins.ecommerce.dto.FabricanteDTO;
import br.unitins.ecommerce.model.produto.Fabricante;

public interface FabricanteService {
    
    List<Fabricante> getAll();
    
    Fabricante getById(Long id);

    Fabricante insert(FabricanteDTO fabricanteDTO);

    Fabricante update(Long id, FabricanteDTO fabricanteDTO);

    void delete(Long id);
}
