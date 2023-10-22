package br.unitins.ecommerce.service.game;

import java.util.List;

import br.unitins.ecommerce.dto.game.GameDTO;
import br.unitins.ecommerce.dto.game.GameResponseDTO;

public interface GameService {
    
    List<GameResponseDTO> getAll();
    
    List<GameResponseDTO> getAll(int page, int pageSize);
    
    GameResponseDTO getById(Long id);

    GameResponseDTO insert(GameDTO gameDTO);

    GameResponseDTO update(Long id, GameDTO gameDTO);

    void delete(Long id);

    List<GameResponseDTO> getByNome(String nome, int page, int pageSize);

    Long count();

    Long countByNome(String nome);
}
