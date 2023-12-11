package br.unitins.ecommerce.dto.itempedido;

import java.util.List;

import br.unitins.ecommerce.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO (
    Integer quantidade,
    Double preco,
    Long idProduto,
    String nome
) {

    public ItemPedidoResponseDTO (ItemPedido itemPedido) {

        this(itemPedido.getQuantidade(), itemPedido.getPreco(), itemPedido.getGame().getId(), itemPedido.getGame().getNome());
    }

    public static List<ItemPedidoResponseDTO> valueOf(List<ItemPedido> item) {
        return item.stream().map(ItemPedidoResponseDTO::new).toList();
     }
}
