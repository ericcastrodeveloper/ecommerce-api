package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.dto.PedidoDTO;
import br.com.ecommerce.ecommerceapi.exception.InsufficientStockException;
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
    public List<PedidoDTO> findAll(){
        return pedidoService.findAll();
    }

    @GetMapping("{id}")
    public PedidoDTO findById(@RequestParam Integer id){
        return pedidoService.findById(id);
    }

    @PostMapping
    public PedidoDTO save(@RequestBody PedidoDTO pedidoDTO) throws InsufficientStockException {
        return pedidoService.save(pedidoDTO);
    }

    @PutMapping({"id"})
    public PedidoDTO update(@RequestParam Integer id, @RequestBody PedidoDTO pedidoDTO) throws InsufficientStockException {
        return pedidoService.update(id, pedidoDTO);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        pedidoService.delete(id);
    }
}
