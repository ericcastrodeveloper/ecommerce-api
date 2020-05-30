package br.com.ecommerce.ecommerceapi.model;

import br.com.ecommerce.ecommerceapi.dto.StatusDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "TB_STATUS")
@Entity
public class Status implements Serializable {

    @Id
    @Column(name = "id_status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    public Status() {
    }

    public Status(StatusDTO statusDTO) {
        this.descricao = statusDTO.getDescricao();
    }

    public Status(Integer id) {
        this.id = id;
    }
}
