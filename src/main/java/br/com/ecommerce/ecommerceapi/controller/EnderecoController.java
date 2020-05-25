package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.model.Endereco;
import br.com.ecommerce.ecommerceapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> findAll(){
        return enderecoService.findAll();
    }

    @GetMapping("{id}")
    public Endereco findById(@RequestParam Integer id){
        return enderecoService.findById(id);
    }

    @PostMapping
    public Endereco save(@RequestBody Endereco endereco){
        return enderecoService.save(endereco);
    }

    @PutMapping({"id"})
    public Endereco update(@RequestParam Integer id, @RequestBody Endereco endereco){
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
         enderecoService.delete(id);
    }
}
