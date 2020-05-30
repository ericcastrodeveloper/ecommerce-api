package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {
    
    List<ProdutoDTO> findAll();

    ProdutoDTO findById(Integer id);

    ProdutoDTO save(ProdutoDTO produtoDTO);

    ProdutoDTO update(Integer id, ProdutoDTO produtoDTO);

    void delete(Integer id);
}
