package br.unitins.ecommerce.service.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.ecommerce.dto.itempedido.ItemPedidoDTO;
import br.unitins.ecommerce.dto.pedido.CartaoCreditoDTO;
import br.unitins.ecommerce.dto.pedido.PedidoDTO;
import br.unitins.ecommerce.dto.pedido.PedidoResponseDTO;
import br.unitins.ecommerce.model.pedido.ItemPedido;
import br.unitins.ecommerce.model.pedido.Pedido;
import br.unitins.ecommerce.model.produto.Game;
import br.unitins.ecommerce.repository.BoletoBancarioRepository;
import br.unitins.ecommerce.repository.CartaoCreditoRepository;
import br.unitins.ecommerce.repository.GameRepository;
import br.unitins.ecommerce.repository.ItemPedidoRepository;
import br.unitins.ecommerce.repository.PedidoRepository;
import br.unitins.ecommerce.repository.PixRepository;
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
    
    @Inject
    BoletoBancarioRepository boletoBancarioRepository;
    
    @Inject
    PixRepository pixRepository;
    
    @Inject
    CartaoCreditoRepository cartaoCreditoRepository;
    
    @Inject
    ItemPedidoRepository itemPedidoRepository;

    @Override
    public List<PedidoResponseDTO> getAll(String login) {
        
        List<Pedido> list = pedidoRepository.findByUsuarioWhereIsFinished(usuarioRepository.findByLogin(login));

        if (list == null)
            throw new NullPointerException("pedido não encontrada");

        return list.stream().map(PedidoResponseDTO::new).toList();
    }

    @Override
    public PedidoResponseDTO getPedidoEmAndamento(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPedidoEmAndamento'");
    }

    @Override
    public void insertItemIntoPedido(Long idUsuario, ItemPedidoDTO itemPedidoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertItemIntoPedido'");
    }

    @Override
    public void removeItemPedido(Long idUsuario, Long idItemPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemPedido'");
    }

    @Override
    public void efetuarPagamentoBoleto(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'efetuarPagamentoBoleto'");
    }

    @Override
    public void efetuarPagamentoPix(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'efetuarPagamentoPix'");
    }

    @Override
    public void efetuarPagamentoCartaoCredito(Long idUsuario, CartaoCreditoDTO cartaoCreditoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'efetuarPagamentoCartaoCredito'");
    }

    @Override
    public void cancelarPedido(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarPedido'");
    }

    @Override
    public void finishPedido(Long idPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishPedido'");
    }
}
