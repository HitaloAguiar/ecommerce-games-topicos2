package br.unitins.ecommerce.service.cidade;

import java.util.List;

import br.unitins.ecommerce.dto.CidadeDTO;
import br.unitins.ecommerce.model.endereco.Cidade;

public interface CidadeService {
    
    List<Cidade> getAll();
    
    Cidade getById(Long id);

    Cidade insert(CidadeDTO cidadeDTO);

    Cidade update(Long id, CidadeDTO cidadeDTO);

    void delete(Long id);
}
