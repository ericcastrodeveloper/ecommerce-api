package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.dto.ClienteDTO;
import br.com.ecommerce.ecommerceapi.dto.EnderecoDTO;
import br.com.ecommerce.ecommerceapi.model.Cliente;
import br.com.ecommerce.ecommerceapi.model.Endereco;
import br.com.ecommerce.ecommerceapi.repository.ClienteRepository;
import br.com.ecommerce.ecommerceapi.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Integer id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return new ClienteDTO(cliente);
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.save(new Cliente(clienteDTO));
        return new ClienteDTO(cliente);
    }

    @Override
    public ClienteDTO update(Integer id, ClienteDTO clienteDTO) {
        Cliente clienteAltered = clienteRepository.findById(id).get();
        clienteAltered.setCpf(clienteDTO.getCpf());
        clienteAltered.setEmail(clienteDTO.getEmail());
        clienteAltered.setNome(clienteDTO.getNome());
        clienteAltered.setTelefone(clienteDTO.getTelefone());

        List<EnderecoDTO> enderecoDTOList = clienteDTO.getEnderecoList();
        List<Endereco> enderecoList = new ArrayList<>();
        enderecoDTOList.forEach(enderecoDTO -> enderecoList.add(new Endereco(enderecoDTO)));

        Cliente cliente = clienteRepository.save(new Cliente(clienteDTO));

        return new ClienteDTO(cliente);
    }

    @Override
    public void delete(Integer id) {
         clienteRepository.deleteById(id);
    }
}
