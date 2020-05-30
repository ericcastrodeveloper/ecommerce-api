package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.dto.ProdutoDTO;
import br.com.ecommerce.ecommerceapi.model.Produto;
import br.com.ecommerce.ecommerceapi.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private br.com.ecommerce.ecommerceapi.repository.ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(br.com.ecommerce.ecommerceapi.repository.ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO findById(Integer id) {
        Produto produto = produtoRepository.findById(id).get();
        return new ProdutoDTO(produto);
    }

    @Override
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.save(new Produto(produtoDTO));
        return new ProdutoDTO(produto);
    }

    @Override
    public ProdutoDTO update(Integer id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id).get();
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValorUnitario(produtoDTO.getValorUnitario());
        Produto produtoUpdated = produtoRepository.save(produto);
        return new ProdutoDTO(produtoUpdated);
    }

    @Override
    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }
}
