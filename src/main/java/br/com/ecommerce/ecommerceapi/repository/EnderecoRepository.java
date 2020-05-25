package br.com.ecommerce.ecommerceapi.repository;

import br.com.ecommerce.ecommerceapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
