package br.com.ecommerce.ecommerceapi.repository;

import br.com.ecommerce.ecommerceapi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}