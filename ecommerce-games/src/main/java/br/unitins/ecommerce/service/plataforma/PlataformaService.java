package br.unitins.ecommerce.service.plataforma;

import java.util.List;

import br.unitins.ecommerce.dto.PlataformaDTO;
import br.unitins.ecommerce.model.produto.Plataforma;

public interface PlataformaService {
    
    List<Plataforma> getAll();
    
    Plataforma getById(Long id);

    Plataforma insert(PlataformaDTO plataformaDTO);

    Plataforma update(Long id, PlataformaDTO plataformaDTO);

    void delete(Long id);
}
