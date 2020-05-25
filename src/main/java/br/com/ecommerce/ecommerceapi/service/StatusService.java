package br.com.ecommerce.ecommerceapi.service;

import br.com.ecommerce.ecommerceapi.model.Status;

import java.util.List;

public interface StatusService {
    
    List<Status> findAll();

    Status findById(Integer id);

    Status save(Status status);

    Status update(Integer id, Status status);

    void delete(Integer id);
}
