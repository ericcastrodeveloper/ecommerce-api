package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.model.Estoque;

import java.util.List;

public interface EstoqueService {
    
    List<Estoque> findAll();

    Estoque findById(Integer id);

    Estoque save(Estoque estoque);

    Estoque update(Integer id, Estoque estoque);

    void delete(Integer id);
}
