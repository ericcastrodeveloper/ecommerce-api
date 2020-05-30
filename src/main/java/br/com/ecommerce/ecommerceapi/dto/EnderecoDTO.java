package br.com.ecommerce.ecommerceapi.dto;

import br.com.ecommerce.ecommerceapi.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private String logradouro;
    private String bairro;
    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.complemento = endereco.getComplemento();
    }
}
