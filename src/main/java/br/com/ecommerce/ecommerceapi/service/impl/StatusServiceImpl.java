package br.com.ecommerce.ecommerceapi.service.impl;

import br.com.ecommerce.ecommerceapi.dto.StatusDTO;
import br.com.ecommerce.ecommerceapi.model.Status;
import br.com.ecommerce.ecommerceapi.repository.StatusRepository;
import br.com.ecommerce.ecommerceapi.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusDTO> findAll() {
        return statusRepository.findAll().stream().map(StatusDTO::new).collect(Collectors.toList());
    }

    @Override
    public StatusDTO findById(Integer id) {
        Status status = statusRepository.findById(id).get();
        return new StatusDTO(status);
    }

    @Override
    public StatusDTO save(StatusDTO statusDTO) {
        Status status = statusRepository.save(new Status(statusDTO));
        return new StatusDTO(status);
    }

    @Override
    public StatusDTO update(Integer id, StatusDTO statusDTO) {
        Status status = statusRepository.findById(id).get();
        status.setDescricao(statusDTO.getDescricao());
        Status statusUpdated = statusRepository.save(status);
        return new StatusDTO(statusUpdated);
    }

    @Override
    public void delete(Integer id) {

        statusRepository.deleteById(id);
    }
}
