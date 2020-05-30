package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.dto.EnderecoDTO;

import java.util.List;

public interface EnderecoService {
    
    List<EnderecoDTO> findAll();

    EnderecoDTO findById(Integer id);

    EnderecoDTO save(EnderecoDTO enderecoDTO);

    EnderecoDTO update(Integer id, EnderecoDTO enderecoDTO);

    void delete(Integer id);
}
