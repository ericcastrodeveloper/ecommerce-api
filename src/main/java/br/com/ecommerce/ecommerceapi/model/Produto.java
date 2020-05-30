package br.com.ecommerce.ecommerceapi.model;

import br.com.ecommerce.ecommerceapi.dto.ProdutoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "TB_PRODUTO")
@Entity
public class Produto implements Serializable {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    public Produto() {
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.descricao = produtoDTO.getDescricao();
        this.valorUnitario = produtoDTO.getValorUnitario();
    }

    public Produto(Integer id) {
        this.id = id;
    }
}
