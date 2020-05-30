package br.com.ecommerce.ecommerceapi.dto;

import br.com.ecommerce.ecommerceapi.model.ItemPedido;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ItemPedidoDTO {

    private Integer produtoId;
    private Integer quantidade;
//    private BigDecimal valor;

    public ItemPedidoDTO() {
    }

    public ItemPedidoDTO(ItemPedido itemPedido) {
        this.produtoId = itemPedido.getProduto().getId();
        this.quantidade = itemPedido.getQuantidade();
//        this.valor = itemPedido.getValor();
    }

}
