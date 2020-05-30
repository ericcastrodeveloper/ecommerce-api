package br.com.ecommerce.ecommerceapi.model;

import br.com.ecommerce.ecommerceapi.dto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "TB_ENDERECO")
@Entity
public class Endereco implements Serializable {

    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String bairro;
    private String complemento;

    public Endereco() {
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.logradouro = enderecoDTO.getLogradouro();
        this.bairro = enderecoDTO.getBairro();
        this.complemento = enderecoDTO.getComplemento();
    }

    public Endereco(Integer id) {
        this.id = id;
    }
}
