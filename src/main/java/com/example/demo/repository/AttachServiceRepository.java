package com.example.demo.repository;

import com.example.demo.model.AttachService;
import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttachServiceRepository extends JpaRepository<AttachService, Integer> {
    @Query(value="select * from attach_service where attach_service_name like :attachServiceNameSearch",
            countQuery ="select * from attach_service where attach_service_name like :attachServiceNameSearch",nativeQuery =true)
    Page<AttachService> search(@Param("attachServiceNameSearch")String attachServiceNameSearch, Pageable pageable);
}
