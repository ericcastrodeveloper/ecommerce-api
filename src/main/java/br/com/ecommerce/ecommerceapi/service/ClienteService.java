package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Integer id);

    Cliente save(Cliente cliente);

    Cliente update(Integer id, Cliente cliente);

    void delete(Integer id);
}
