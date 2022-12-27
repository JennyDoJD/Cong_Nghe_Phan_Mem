package com.example.demo.service;

import com.example.demo.model.AttachService;
import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    List<Service> findAll();

    Page<Service> findByAll(Pageable pageable, String serviceNameSearch, String attachServiceIdSearch);


}
