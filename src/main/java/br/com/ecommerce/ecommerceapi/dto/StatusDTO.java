package br.com.ecommerce.ecommerceapi.dto;

import br.com.ecommerce.ecommerceapi.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDTO {

    private String descricao;

    public StatusDTO() {
    }

    public StatusDTO(Status status){
        this.descricao = status.getDescricao();
    }
}
