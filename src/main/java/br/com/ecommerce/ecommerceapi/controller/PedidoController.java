package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.model.Pedido;
import br.com.ecommerce.ecommerceapi.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> findAll(){
        return pedidoService.findAll();
    }

    @GetMapping("{id}")
    public Pedido findById(@RequestParam Integer id){
        return pedidoService.findById(id);
    }

    @PostMapping
    public Pedido save(@RequestBody Pedido pedido){
        return pedidoService.save(pedido);
    }

    @PutMapping({"id"})
    public Pedido update(@RequestParam Integer id, @RequestBody Pedido pedido){
        return pedidoService.update(id, pedido);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        pedidoService.delete(id);
    }
}
