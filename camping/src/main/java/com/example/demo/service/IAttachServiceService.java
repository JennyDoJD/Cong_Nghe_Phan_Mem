package com.example.demo.service;

import com.example.demo.model.AttachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAttachServiceService {
    List<AttachService> findAll();

    Page<AttachService> findAll(Pageable pageable);

    Page<AttachService> findByAll(Pageable pageable, String attachServiceNameSearch);

    void save(AttachService attachService);

    Optional<AttachService> findById(int attach_service_id);

    void delete (int attach_service_id);
}
