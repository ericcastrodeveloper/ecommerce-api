package br.com.ecommerce.ecommerceapi.repository;

import br.com.ecommerce.ecommerceapi.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}
