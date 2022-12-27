package com.example.demo.service;

import com.example.demo.model.AttachService;
import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    List<Service> findAll();

    Page<Service> findAll(Pageable pageable);

    Page<Service> findByAll(Pageable pageable, String serviceNameSearch, String attachServiceIdSearch);

    void save(Service service);

    Optional<Service> findById(int service_id);

    void delete (int service_id
    
    Page<Service> findByAll(Pageable pageable, String serviceNameSearch, String attachServiceIdSearch);

    void delete (int service_id);

}
