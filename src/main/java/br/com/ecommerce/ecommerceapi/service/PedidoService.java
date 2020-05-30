package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.dto.PedidoDTO;
import br.com.ecommerce.ecommerceapi.exception.InsufficientStockException;

import java.util.List;

public interface PedidoService {
    
    List<PedidoDTO> findAll();

    PedidoDTO findById(Integer id);

    PedidoDTO save(PedidoDTO pedidoDTO) throws InsufficientStockException;

    PedidoDTO update(Integer id, PedidoDTO pedidoDTO) throws InsufficientStockException;

    void delete(Integer id);
}
