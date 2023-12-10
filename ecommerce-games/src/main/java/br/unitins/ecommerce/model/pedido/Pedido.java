package br.unitins.ecommerce.model.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.ecommerce.model.DefaultEntity;
import br.unitins.ecommerce.model.endereco.Endereco;
import br.unitins.ecommerce.model.pedido.pagamento.Pagamento;
import br.unitins.ecommerce.model.usuario.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido extends DefaultEntity {
    
    private LocalDateTime dataHoraCompra;
    
    private Double totalPedido;

    private Boolean ifConcluida;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_pagamento", unique = true)
    private Pagamento pagamento;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pedido")
    private List<ItemPedido> itens;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(LocalDateTime dataHora) {
        this.dataHoraCompra = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Boolean getIfConcluida() {
        return ifConcluida;
    }

    public void setIfConcluida(Boolean ifConcluida) {
        this.ifConcluida = ifConcluida;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
