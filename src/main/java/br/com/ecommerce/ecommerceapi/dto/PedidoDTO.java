package br.com.ecommerce.ecommerceapi.dto;

import br.com.ecommerce.ecommerceapi.model.Pedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {

    private Integer clienteId;
    private LocalDateTime dataPedido;
    private Integer statusId;
    private Integer enderecoId;
    private List<ItemPedidoDTO> itemPedidoDTOS;
    private BigDecimal valorTotal;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.clienteId = pedido.getCliente().getId();
        this.dataPedido = pedido.getDataPedido();
        this.statusId = pedido.getStatus().getId();
        this.enderecoId = pedido.getEndereco().getId();
        this.valorTotal = pedido.getValorTotal();
        itemPedidoDTOS = new ArrayList<>();
        pedido.getItemPedidoList().stream().forEach(itemPedido -> itemPedidoDTOS.add(new ItemPedidoDTO(itemPedido)));
    }
}
