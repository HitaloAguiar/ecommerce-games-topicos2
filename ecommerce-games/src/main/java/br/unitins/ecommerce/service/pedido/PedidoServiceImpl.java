package br.unitins.ecommerce.service.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.ecommerce.dto.itempedido.ItemPedidoDTO;
import br.unitins.ecommerce.dto.pedido.PedidoDTO;
import br.unitins.ecommerce.dto.pedido.PedidoResponseDTO;
import br.unitins.ecommerce.model.ItemPedido;
import br.unitins.ecommerce.model.Pedido;
import br.unitins.ecommerce.model.produto.Game;
import br.unitins.ecommerce.repository.GameRepository;
import br.unitins.ecommerce.repository.PedidoRepository;
import br.unitins.ecommerce.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {
    
    @Inject
    GameRepository gameRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PedidoRepository pedidoRepository;

    private static final Logger LOG = Logger.getLogger(PedidoServiceImpl.class);

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto, String login) {
        Pedido pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());

        LOG.info(dto);
        LOG.info(dto.itens());

        // calculo do total do pedido
        Double total = 0.0;
        for (ItemPedidoDTO itemDto : dto.itens()) {
            total += (itemDto.preco() * itemDto.quantidade());
        }
        pedido.setTotalPedido(total);

        // adicionando os itens do pedido
        pedido.setItens(new ArrayList<ItemPedido>());
        for (ItemPedidoDTO itemDto : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setPreco(itemDto.preco());
            item.setQuantidade(itemDto.quantidade());
            item.setPedido(pedido);
            LOG.info(itemDto.idGame());
            Game game = gameRepository.findById(itemDto.idGame());
            item.setGame(game);

            pedido.getItens().add(item);
        }

        // buscando o usuario pelo login
        pedido.setUsuario(usuarioRepository.findByLogin(login));

        // salvando no banco
        pedidoRepository.persist(pedido);

        // atualizando o estoque
  

        return new PedidoResponseDTO(pedido);
        
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return new PedidoResponseDTO(pedidoRepository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return pedidoRepository.listAll().stream()
            .map(PedidoResponseDTO::new).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByAll(String login) {
        
        return pedidoRepository.findAll(login).stream()
            .map(PedidoResponseDTO::new).toList();
    }
}
