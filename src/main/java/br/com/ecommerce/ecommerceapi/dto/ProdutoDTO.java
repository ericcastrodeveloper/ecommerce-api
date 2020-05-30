package br.com.ecommerce.ecommerceapi.dto;

import br.com.ecommerce.ecommerceapi.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {

    private String descricao;
    private BigDecimal valorUnitario;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.descricao = produto.getDescricao();
        this.valorUnitario = produto.getValorUnitario();
    }
}
