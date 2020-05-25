package br.com.ecommerce.ecommerceapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "TB_ITEM_PEDIDO")
@Entity
public class ItemPedido implements Serializable {

    @Id
    @Column(name = "id_item_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;
    private BigDecimal valor;

}
