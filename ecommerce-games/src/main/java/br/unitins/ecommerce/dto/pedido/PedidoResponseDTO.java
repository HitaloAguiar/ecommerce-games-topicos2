package br.unitins.ecommerce.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.ecommerce.dto.itempedido.ItemPedidoResponseDTO;
import br.unitins.ecommerce.dto.usuario.UsuarioResponseDTO;
import br.unitins.ecommerce.model.pedido.Pedido;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime dataHora,
    UsuarioResponseDTO usuario,
    Double totalPedido,
    List<ItemPedidoResponseDTO> itens
) {
    
    public PedidoResponseDTO (Pedido pedido) {

        this(pedido.getId(), pedido.getDataHoraCompra(), new UsuarioResponseDTO(pedido.getUsuario(), pedido.getUsuario().getPerfil().getLabel()), pedido.getTotalPedido(), ItemPedidoResponseDTO.valueOf(pedido.getItens()));
    }
}
