package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.dto.EstoqueDTO;

import java.util.List;

public interface EstoqueService {
    
    List<EstoqueDTO> findAll();

    EstoqueDTO findById(Integer id);

    EstoqueDTO save(EstoqueDTO estoqueDTO);

    EstoqueDTO update(Integer id, EstoqueDTO estoqueDTO);

    void delete(Integer id);
}
