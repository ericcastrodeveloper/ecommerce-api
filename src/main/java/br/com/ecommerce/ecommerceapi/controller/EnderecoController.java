package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.dto.EnderecoDTO;
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
    public List<EnderecoDTO> findAll(){
        return enderecoService.findAll();
    }

    @GetMapping("{id}")
    public EnderecoDTO findById(@RequestParam Integer id){
        return enderecoService.findById(id);
    }

    @PostMapping
    public EnderecoDTO save(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.save(enderecoDTO);
    }

    @PutMapping({"id"})
    public EnderecoDTO update(@RequestParam Integer id, @RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.update(id, enderecoDTO);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
         enderecoService.delete(id);
    }
}
