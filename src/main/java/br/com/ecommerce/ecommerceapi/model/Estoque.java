package br.com.ecommerce.ecommerceapi.model;

import br.com.ecommerce.ecommerceapi.dto.EstoqueDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "TB_ESTOQUE")
@Entity
public class Estoque implements Serializable {

    @Id
    @Column(name = "id_estoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;
    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Estoque() {
    }

    public Estoque(EstoqueDTO estoqueDTO) {
        this.produto = new Produto(estoqueDTO.getProdutoId());
        this.quantidade = estoqueDTO.getQuantidade();
    }

    public Estoque(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }
}
