package br.com.ecommerce.ecommerceapi.controller;

import br.com.ecommerce.ecommerceapi.model.Status;
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
    public List<Status> findAll(){
        return statusService.findAll();
    }

    @GetMapping("[id]")
    public Status findById(@RequestParam Integer id){
        return statusService.findById(id);
    }

    @PostMapping
    public Status save(@RequestBody Status Status){
        return statusService.save(Status);
    }

    @PutMapping({"id"})
    public Status update(@RequestParam Integer id, @RequestBody Status Status){
        return statusService.update(id, Status);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam Integer id){
        statusService.delete(id);
    }
}
