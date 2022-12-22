package com.example.demo.service.impl;

import com.example.demo.model.AttachService;
import com.example.demo.repository.AttachServiceRepository;
import com.example.demo.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachServiceServiceImpl implements IAttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;


    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Page<AttachService> findAll(Pageable pageable) {
        return attachServiceRepository.findAll(pageable);
    }

    @Override
    public Page<AttachService> findByAll(Pageable pageable, String attachServiceNameSearch) {
        return attachServiceRepository.search("%" + attachServiceNameSearch + "%", pageable);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public Optional<AttachService> findById(int attach_service_id) {
        return attachServiceRepository.findById(attach_service_id);
    }

    @Override
    public void delete(int attach_service_id) {
        attachServiceRepository.deleteById(attach_service_id);
    }
}
