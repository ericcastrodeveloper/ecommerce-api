package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.dto.EstoqueDTO;
import br.com.ecommerce.ecommerceapi.model.Estoque;
import br.com.ecommerce.ecommerceapi.model.Produto;
import br.com.ecommerce.ecommerceapi.repository.EstoqueRepository;
import br.com.ecommerce.ecommerceapi.repository.ProdutoRepository;
import br.com.ecommerce.ecommerceapi.service.EstoqueService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    private EstoqueRepository estoqueRepository;
    private ProdutoRepository produtoRepository;

    public EstoqueServiceImpl(EstoqueRepository estoqueRepository, ProdutoRepository produtoRepository) {
        this.estoqueRepository = estoqueRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Cacheable(value = "allEstoqueCache", unless= "#result.size() == 0")
    public List<EstoqueDTO> findAll() {
        return estoqueRepository.findAll().stream().map(EstoqueDTO::new).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "estoqueCache", key = "#produtoId")
    public EstoqueDTO findById(Integer id) {
        Estoque estoque = estoqueRepository.findById(id).get();
        return new EstoqueDTO(estoque);
    }

    @Override
    @Caching(
            put= { @CachePut(value= "estoqueCache", key= "#estoqueDTO.produtoId") },
            evict= { @CacheEvict(value= "allEstoqueCache", allEntries= true) }
    )
    public EstoqueDTO save(EstoqueDTO estoqueDTO) {
        Produto produto = produtoRepository.findById(estoqueDTO.getProdutoId()).get();
        Estoque estoque = new Estoque(estoqueDTO.getQuantidade(), produto);
        Estoque estoqueSalvo = estoqueRepository.saveAndFlush(estoque);
        return new EstoqueDTO(estoqueSalvo);
    }

    @Override
    @Caching(
            put= { @CachePut(value= "estoqueCache", key= "#estoqueDTO.produtoId") },
            evict= { @CacheEvict(value= "allEstoqueCache", allEntries= true) }
    )
    public EstoqueDTO update(Integer id, EstoqueDTO estoqueDTO) {
        Estoque estoque = estoqueRepository.findById(id).get();
        estoque.setProduto(new Produto(estoqueDTO.getProdutoId()));
        estoque.setQuantidade(estoqueDTO.getQuantidade());
        Estoque estoqueUpdated = estoqueRepository.save(estoque);
        return new EstoqueDTO(estoqueUpdated);
    }

    @Override
    @Caching(
            evict= {
                    @CacheEvict(value= "estoqueCache", key= "#produtoId"),
                    @CacheEvict(value= "allEstoqueCache", allEntries= true)
            }
    )
    public void delete(Integer id) {
        estoqueRepository.deleteById(id);
    }
}
