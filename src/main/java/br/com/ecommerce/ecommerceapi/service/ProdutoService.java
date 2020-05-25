package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.model.Produto;

import java.util.List;

public interface ProdutoService {
    
    List<Produto> findAll();

    Produto findById(Integer id);

    Produto save(Produto produto);

    Produto update(Integer id, Produto produto);

    void delete(Integer id);
}
