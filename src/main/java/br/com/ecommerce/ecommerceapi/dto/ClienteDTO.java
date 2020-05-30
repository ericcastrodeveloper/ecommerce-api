package br.com.ecommerce.ecommerceapi.dto;

import br.com.ecommerce.ecommerceapi.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClienteDTO {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<EnderecoDTO> enderecoList;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        enderecoList = new ArrayList<>();
        cliente.getEnderecoList().forEach(endereco -> enderecoList.add(new EnderecoDTO(endereco)));
    }
}
