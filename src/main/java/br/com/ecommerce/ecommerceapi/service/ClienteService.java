package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> findAll();

    ClienteDTO findById(Integer id);

    ClienteDTO save(ClienteDTO clienteDTO);

    ClienteDTO update(Integer id, ClienteDTO clienteDTO);

    void delete(Integer id);
}
