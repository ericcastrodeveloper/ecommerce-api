package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.dto.StatusDTO;
import br.com.ecommerce.ecommerceapi.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("status")
public class StatusController {

    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<StatusDTO> findAll(){
        return statusService.findAll();
    }

    @GetMapping("[id]")
    public StatusDTO findById(@RequestParam Integer id){
        return statusService.findById(id);
    }

    @PostMapping
    public StatusDTO save(@RequestBody StatusDTO statusDTO){
        return statusService.save(statusDTO);
    }

    @PutMapping({"id"})
    public StatusDTO update(@RequestParam Integer id, @RequestBody StatusDTO statusDTO){
        return statusService.update(id, statusDTO);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        statusService.delete(id);
    }
}
