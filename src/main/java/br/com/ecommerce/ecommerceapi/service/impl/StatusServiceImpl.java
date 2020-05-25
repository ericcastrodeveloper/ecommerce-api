package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.model.Status;
import br.com.ecommerce.ecommerceapi.repository.StatusRepository;
import br.com.ecommerce.ecommerceapi.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Integer id) {
        return statusRepository.findById(id).get();
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Status update(Integer id, Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void delete(Integer id) {

        statusRepository.deleteById(id);
    }
}
