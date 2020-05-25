package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.model.Endereco;
import br.com.ecommerce.ecommerceapi.repository.EnderecoRepository;
import br.com.ecommerce.ecommerceapi.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {


    private EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco findById(Integer id) {
        return enderecoRepository.findById(id).get();
    }

    @Override
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco update(Integer id, Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
