package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.model.Pedido;
import br.com.ecommerce.ecommerceapi.repository.PedidoRepository;
import br.com.ecommerce.ecommerceapi.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id).get();
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Integer id, Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void delete(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
