package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.model.Produto;
import br.com.ecommerce.ecommerceapi.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @GetMapping("{id}")
    public Produto findById(@RequestParam Integer id){
        return produtoService.findById(id);
    }

    @PostMapping
    public Produto save(@RequestBody Produto Produto){
        return produtoService.save(Produto);
    }

    @PutMapping({"id"})
    public Produto update(@RequestParam Integer id, @RequestBody Produto Produto){
        return produtoService.update(id, Produto);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        produtoService.delete(id);
    }

}
