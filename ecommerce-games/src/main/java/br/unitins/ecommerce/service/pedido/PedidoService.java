package br.unitins.ecommerce.service.pedido;

import java.util.List;

import br.unitins.ecommerce.dto.itempedido.ItemPedidoDTO;
import br.unitins.ecommerce.dto.pedido.CartaoCreditoDTO;
import br.unitins.ecommerce.dto.pedido.PedidoResponseDTO;

public interface PedidoService {

    public List<PedidoResponseDTO> getAll(String login);

    PedidoResponseDTO getPedidoEmAndamento (Long idUsuario);
    
    void insertItemIntoPedido (Long idUsuario, ItemPedidoDTO itemPedidoDTO);

    void removeItemPedido (Long idUsuario, Long idItemCompra);

    void efetuarPagamentoBoleto(Long idUsuario);

    void efetuarPagamentoPix(Long idUsuario);

    void efetuarPagamentoCartaoCredito(Long idUsuario, CartaoCreditoDTO cartaoCreditoDTO);

    void cancelarPedido(Long idUsuario);

    void finishPedido (Long idCompra);

}
