package br.unitins.ecommerce.dto.pedido;

import java.util.List;

import br.unitins.ecommerce.dto.itempedido.ItemPedidoDTO;

public record PedidoDTO(
    List<ItemPedidoDTO> itens
) {
    
}
