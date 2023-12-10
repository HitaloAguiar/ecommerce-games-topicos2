package br.unitins.ecommerce.dto.pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.unitins.ecommerce.dto.endereco.EnderecoResponseDTO;
import br.unitins.ecommerce.dto.itempedido.ItemPedidoResponseDTO;
import br.unitins.ecommerce.dto.usuario.UsuarioResponseDTO;
import br.unitins.ecommerce.model.pedido.Pedido;
import br.unitins.ecommerce.model.pedido.pagamento.BoletoBancario;
import br.unitins.ecommerce.model.pedido.pagamento.Pix;

public record PedidoResponseDTO(
    Long id,
    LocalDateTime dataHoraPedido,
    String totalPedido,
    String formaPagamento,
    String statusPagamento,
    LocalDate dataPagamento,
    String statusPedido,
    EnderecoResponseDTO enderecoResponseDTO,
    UsuarioResponseDTO usuario,
    List<ItemPedidoResponseDTO> itens
) {
    
    public PedidoResponseDTO (Pedido pedido) {

        this(pedido.getId(),
            pedido.getDataHoraPedido(),
            "R$ " + String.format("%.2f", pedido.getTotalPedido()),
            pedido.getPagamento() instanceof Pix ? "Pix" : pedido.getPagamento() instanceof BoletoBancario ? "Boleto Bancário" : "Cartão de Crédito",
            pedido.getPagamento() != null?
                pedido.getPagamento().getConfirmacaoPagamento() == true?
                    "Pagamento efetuado":
                    "Pagamento não efetuado" :
            null,
            pedido.getPagamento() != null ?
                pedido.getPagamento().getDataConfirmacaoPagamento() :
                null,
            pedido.getIfConcluida() == true ? "Compra concluída" : "Compra em andamento",
            new EnderecoResponseDTO(pedido.getEndereco(), pedido.getUsuario().getLogin()),
            new UsuarioResponseDTO(pedido.getUsuario(), pedido.getUsuario().getPerfil().getLabel()),
            ItemPedidoResponseDTO.valueOf(pedido.getItens()));
    }
}
