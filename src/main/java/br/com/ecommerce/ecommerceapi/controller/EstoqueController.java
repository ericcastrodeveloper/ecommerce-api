package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.dto.EstoqueDTO;
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
    public List<EstoqueDTO> findAll(){
        return estoqueService.findAll();
    }

    @GetMapping("{id}")
    public EstoqueDTO findById(@RequestParam Integer id){
        return estoqueService.findById(id);
    }

    @PostMapping
    public EstoqueDTO save(@RequestBody EstoqueDTO estoqueDTO){
        return estoqueService.save(estoqueDTO);
    }

    @PutMapping({"id"})
    public EstoqueDTO update(@RequestParam Integer id, @RequestBody EstoqueDTO estoqueDTO){
        return estoqueService.update(id, estoqueDTO);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        estoqueService.delete(id);
    }
}
