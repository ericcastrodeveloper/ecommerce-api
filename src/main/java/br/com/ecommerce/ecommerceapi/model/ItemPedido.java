package br.com.ecommerce.ecommerceapi.model;

import br.com.ecommerce.ecommerceapi.dto.ItemPedidoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "TB_ITEM_PEDIDO")
@Entity
public class ItemPedido implements Serializable {

    @Id
    @Column(name = "id_item_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    private Integer quantidade;

    public ItemPedido() {
    }

    public ItemPedido(ItemPedidoDTO itemPedidoDTO) {
        this.produto = new Produto(itemPedidoDTO.getProdutoId());
        this.quantidade = itemPedidoDTO.getQuantidade();
    }
}
