package br.com.ecommerce.ecommerceapi.model;

import br.com.ecommerce.ecommerceapi.dto.ClienteDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "TB_CLIENTE")
@Entity
public class Cliente implements Serializable {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private List<Endereco> enderecoList;

    public Cliente() {
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.nome = clienteDTO.getNome();
        this.cpf = clienteDTO.getCpf();
        this.email = clienteDTO.getEmail();
        this.telefone = clienteDTO.getTelefone();
        enderecoList = new ArrayList<>();
        clienteDTO.getEnderecoList().forEach(enderecoDTO -> enderecoList.add(new Endereco(enderecoDTO)));
    }

    public Cliente(Integer id) {
        this.id = id;
    }
}
