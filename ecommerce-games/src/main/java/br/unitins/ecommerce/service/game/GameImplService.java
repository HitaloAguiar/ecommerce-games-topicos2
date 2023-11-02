package br.unitins.ecommerce.service.game;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import br.unitins.ecommerce.dto.game.GameDTO;
import br.unitins.ecommerce.dto.game.GameResponseDTO;
import br.unitins.ecommerce.model.produto.Game;
import br.unitins.ecommerce.repository.DeveloperRepository;
import br.unitins.ecommerce.repository.GameRepository;
import br.unitins.ecommerce.repository.GeneroRepository;
import br.unitins.ecommerce.repository.PlataformaRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class GameImplService implements GameService {

    @Inject
    Validator validator;

    @Inject
    GameRepository gameRepository;

    @Inject
    DeveloperRepository developerRepository;

    @Inject
    GeneroRepository generoRepository;

    @Inject
    PlataformaRepository plataformaRepository;

    private DateTimeFormatter formatterGetAll = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private DateTimeFormatter formatterGetById = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<GameResponseDTO> getAll() {
        
        return gameRepository.findAll(sort).stream().map(game -> new GameResponseDTO(game, formatterGetAll)).toList();
    }

    @Override
    public List<GameResponseDTO> getAll(int page, int pageSize) {
        
        return gameRepository.findAll(sort).page(page, pageSize).stream().map(game -> new GameResponseDTO(game, formatterGetAll)).toList();
    }

    @Override
    public GameResponseDTO getById(Long id) {
        
        Game game = gameRepository.findById(id);

        if (game == null)
            throw new NotFoundException("Não encontrado");

        return new GameResponseDTO(game, formatterGetById);
    }

    @Override
    @Transactional
    public GameResponseDTO insert(@Valid GameDTO gameDTO) throws ConstraintViolationException {
        
        validar(gameDTO);

        Game game = new Game();
        
        game.setNome(gameDTO.nome());

        game.setDescricao(gameDTO.descricao());

        game.setPreco(gameDTO.preco());

        game.setAnoLancamento(gameDTO.anoLancamento());

        game.setDeveloper(developerRepository.findById(gameDTO.developer()));

        for (Long genero : gameDTO.generos()) {
            
            game.plusGeneros(generoRepository.findById(genero));
        }

        for (Long plataforma : gameDTO.plataformas()) {
            
            game.plusPlataformas(plataformaRepository.findById(plataforma));
        }

        gameRepository.persist(game);

        return new GameResponseDTO(game);
    }

    @Override
    @Transactional
    public GameResponseDTO update(Long id, @Valid GameDTO gameDTO) throws ConstraintViolationException {
        
        validar(gameDTO);

        int tamanhoArray;

        Game game = gameRepository.findById(id);

        if (game == null)
            throw new NotFoundException("Número fora das opções disponíveis");
        
        game.setNome(gameDTO.nome());

        game.setDescricao(gameDTO.descricao());

        game.setPreco(gameDTO.preco());

        game.setAnoLancamento(gameDTO.anoLancamento());

        game.setDeveloper(developerRepository.findById(gameDTO.developer()));

        tamanhoArray = game.getGeneros().size();

        while (tamanhoArray != 0) {
            
            game.getGeneros().remove(0);

            tamanhoArray--;
        }

        for (Long genero : gameDTO.generos()) {
            
            game.plusGeneros(generoRepository.findById(genero));
        }

        tamanhoArray = game.getPlataformas().size();

        while (tamanhoArray != 0) {
            
            game.getPlataformas().remove(0);

            tamanhoArray--;
        }

        for (Long plataforma : gameDTO.plataformas()) {
            
            game.plusPlataformas(plataformaRepository.findById(plataforma));
        }
        
        return new GameResponseDTO(game);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Game game = gameRepository.findById(id);

        if (gameRepository.isPersistent(game))
            gameRepository.delete(game);

        else
            throw new NotFoundException("Nenhum game encontrado");
    }

    @Override
    @Transactional
    public GameResponseDTO salvarImage(Long id, String nomeImagem) {
        
        Game entity = gameRepository.findById(id);
        entity.setNomeImagem(nomeImagem);

        return new GameResponseDTO(entity);
    }

    @Override
    public List<GameResponseDTO> getByNome(String nome, int page, int pageSize) {
        
        return gameRepository.findByNome(nome, sort).page(page, pageSize).stream().map(game -> new GameResponseDTO(game, formatterGetAll)).toList();        
    }

    @Override
    public Long count() {

        return gameRepository.count();
    }

    @Override
    public Long countByNome(String nome) {

        return gameRepository.findByNome(nome, sort).count();
    }
 
    private void validar(GameDTO gameDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<GameDTO>> violations = validator.validate(gameDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
}
