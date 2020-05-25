package br.com.ecommerce.ecommerceapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
//    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
////    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", updatable = false, insertable = false)
//    private List<Pedido> pedidoList;

}
