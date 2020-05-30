package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.dto.ClienteDTO;
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
    public List<ClienteDTO> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public ClienteDTO findById(@RequestParam  Integer id){
        return clienteService.findById(id);
    }

    @PostMapping
    public ClienteDTO save(@RequestBody ClienteDTO clienteDTO){
        return clienteService.save(clienteDTO);
    }

    @PutMapping({"id"})
    public ClienteDTO update(@RequestParam Integer id, @RequestBody ClienteDTO clienteDTO){
        return clienteService.update(id, clienteDTO);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
         clienteService.delete(id);
    }


}
