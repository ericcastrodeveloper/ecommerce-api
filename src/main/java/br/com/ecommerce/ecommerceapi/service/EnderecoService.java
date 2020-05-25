package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.model.Endereco;

import java.util.List;

public interface EnderecoService {
    
    List<Endereco> findAll();

    Endereco findById(Integer id);

    Endereco save(Endereco endereco);

    Endereco update(Integer id, Endereco endereco);

    void delete(Integer id);
}
