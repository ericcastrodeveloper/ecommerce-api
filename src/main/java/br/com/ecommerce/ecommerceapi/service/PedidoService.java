package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.model.Pedido;

import java.util.List;

public interface PedidoService {
    
    List<Pedido> findAll();

    Pedido findById(Integer id);

    Pedido save(Pedido pedido);

    Pedido update(Integer id, Pedido pedido);

    void delete(Integer id);
}
