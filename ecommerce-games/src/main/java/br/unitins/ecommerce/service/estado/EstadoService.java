package br.unitins.ecommerce.service.estado;

import java.util.List;

import br.unitins.ecommerce.dto.EstadoDTO;
import br.unitins.ecommerce.model.endereco.Estado;

public interface EstadoService {
    
    List<Estado> getAll();
    
    Estado getById(Long id);

    Estado insert(EstadoDTO estadoDto);

    Estado update(Long id, EstadoDTO estadoDto);

    void delete(Long id);
}
