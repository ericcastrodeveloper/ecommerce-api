package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.dto.ProdutoDTO;
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
    public List<ProdutoDTO> findAll(){
        return produtoService.findAll();
    }

    @GetMapping("{id}")
    public ProdutoDTO findById(@RequestParam Integer id){
        return produtoService.findById(id);
    }

    @PostMapping
    public ProdutoDTO save(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.save(produtoDTO);
    }

    @PutMapping({"id"})
    public ProdutoDTO update(@RequestParam Integer id, @RequestBody ProdutoDTO produtoDTO){
        return produtoService.update(id, produtoDTO);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        produtoService.delete(id);
    }

}
