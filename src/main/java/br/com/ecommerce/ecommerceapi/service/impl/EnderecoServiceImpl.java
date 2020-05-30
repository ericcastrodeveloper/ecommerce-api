package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.dto.EnderecoDTO;
import br.com.ecommerce.ecommerceapi.model.Endereco;
import br.com.ecommerce.ecommerceapi.repository.EnderecoRepository;
import br.com.ecommerce.ecommerceapi.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {


    private EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<EnderecoDTO> findAll() {
        return enderecoRepository.findAll().stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

    @Override
    public EnderecoDTO findById(Integer id) {
        Endereco endereco = enderecoRepository.findById(id).get();

        return new EnderecoDTO(endereco);
    }

    @Override
    public EnderecoDTO save(EnderecoDTO enderecoDTO) {
        Endereco enderecoSaved = enderecoRepository.save(new Endereco(enderecoDTO));
        return new EnderecoDTO(enderecoSaved);
    }

    @Override
    public EnderecoDTO update(Integer id, EnderecoDTO enderecoDTO) {

        Endereco endereco = enderecoRepository.findById(id).get();
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        Endereco enderecoUpdated = enderecoRepository.save(endereco);
        return new EnderecoDTO(enderecoUpdated);
    }

    @Override
    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
