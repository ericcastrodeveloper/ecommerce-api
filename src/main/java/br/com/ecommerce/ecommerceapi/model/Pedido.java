package br.com.ecommerce.ecommerceapi.model;

import br.com.ecommerce.ecommerceapi.dto.PedidoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Table(name = "TB_PEDIDO")
@Entity
//To suppress serializing properties with null values
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
//Ignoring new fields on JSON objects
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido implements Serializable {

    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    @OneToOne
    @JoinColumn(name = "id_status")
    private Status status;
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_pedido")
    private List<ItemPedido> itemPedidoList;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    public Pedido() {
    }

    public Pedido(PedidoDTO pedidoDTO) {
        this.cliente = new Cliente(pedidoDTO.getClienteId());
        this.dataPedido = pedidoDTO.getDataPedido();
        this.status = new Status(pedidoDTO.getStatusId());
        this.endereco = new Endereco(pedidoDTO.getEnderecoId());
        this.itemPedidoList = new ArrayList<>();
        itemPedidoList = pedidoDTO.getItemPedidoDTOS().stream().map(ItemPedido::new).collect(Collectors.toList());
    }
}
