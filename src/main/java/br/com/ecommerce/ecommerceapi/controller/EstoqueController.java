package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.model.Estoque;
import br.com.ecommerce.ecommerceapi.service.EstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    private EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    public List<Estoque> findAll(){
        return estoqueService.findAll();
    }

    @GetMapping("{id}")
    public Estoque findById(@RequestParam Integer id){
        return estoqueService.findById(id);
    }

    @PostMapping
    public Estoque save(@RequestBody Estoque estoque){
        return estoqueService.save(estoque);
    }

    @PutMapping({"id"})
    public Estoque update(@RequestParam Integer id, @RequestBody Estoque estoque){
        return estoqueService.update(id, estoque);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        estoqueService.delete(id);
    }
}
