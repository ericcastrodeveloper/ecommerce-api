package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.model.Cliente;
import br.com.ecommerce.ecommerceapi.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public Cliente findById(@RequestParam  Integer id){
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping({"id"})
    public Cliente update(@RequestParam Integer id, @RequestBody Cliente cliente){
        return clienteService.update(id, cliente);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
         clienteService.delete(id);
    }


}
