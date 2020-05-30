package br.com.ecommerce.ecommerceapi.dto;

import br.com.ecommerce.ecommerceapi.model.Estoque;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EstoqueDTO implements Serializable {

    private Integer quantidade;
    private Integer produtoId;

    public EstoqueDTO() {
    }

    public EstoqueDTO(Estoque estoque) {
        this.quantidade = estoque.getQuantidade();
        this.produtoId = estoque.getProduto().getId();
    }
}
