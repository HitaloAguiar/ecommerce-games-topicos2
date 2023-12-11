package br.unitins.ecommerce.model.pedido;

import br.unitins.ecommerce.model.DefaultEntity;
import br.unitins.ecommerce.model.produto.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefaultEntity {
    
    private Integer quantidade;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game game;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
