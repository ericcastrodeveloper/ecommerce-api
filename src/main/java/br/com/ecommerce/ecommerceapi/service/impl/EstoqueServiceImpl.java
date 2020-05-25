package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.model.Estoque;
import br.com.ecommerce.ecommerceapi.repository.EstoqueRepository;
import br.com.ecommerce.ecommerceapi.service.EstoqueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    private EstoqueRepository estoqueRepository;

    public EstoqueServiceImpl(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque findById(Integer id) {
        return estoqueRepository.findById(id).get();
    }

    @Override
    public Estoque save(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @Override
    public Estoque update(Integer id, Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @Override
    public void delete(Integer id) {
        estoqueRepository.deleteById(id);
    }
}
