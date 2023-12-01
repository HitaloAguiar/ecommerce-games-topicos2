package br.unitins.ecommerce.service.game;

import java.util.List;

import br.unitins.ecommerce.dto.game.GameDTO;
import br.unitins.ecommerce.dto.game.GameResponseDTO;
import br.unitins.ecommerce.model.produto.Game;
import jakarta.validation.Valid;

public interface GameService {
    
    List<GameResponseDTO> getAll();
    
    List<GameResponseDTO> getAll(int page, int pageSize);
    
    GameResponseDTO getById(Long id);

    GameResponseDTO insert(@Valid GameDTO gameDTO);

    GameResponseDTO update(Long id, @Valid GameDTO gameDTO);

    void delete(Long id);

    GameResponseDTO salvarImage(Long id, String nomeImagem);

    List<GameResponseDTO> getByNome(String nome, int page, int pageSize);

    Long count();

    Long countByNome(String nome);

    byte[] criarRelatorioGames(String filtro);

    byte[] gerarPdf(List<Game> games);
}
