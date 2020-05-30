package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.dto.StatusDTO;

import java.util.List;

public interface StatusService {
    
    List<StatusDTO> findAll();

    StatusDTO findById(Integer id);

    StatusDTO save(StatusDTO status);

    StatusDTO update(Integer id, StatusDTO status);

    void delete(Integer id);
}
