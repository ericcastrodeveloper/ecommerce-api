package br.com.ecommerce.ecommerceapi.repository;

import br.com.ecommerce.ecommerceapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
