package br.com.ecommerce.ecommerceapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @OneToMany
//    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private List<Produto> produtoList;
}
