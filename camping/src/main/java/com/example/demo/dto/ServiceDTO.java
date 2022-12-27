package com.example.demo.dto;

import com.example.demo.model.AttachService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ServiceDTO implements Serializable {
    private Integer service_id;

    @NotEmpty(message = "Không được để trống")
    private String service_name;

    @NotEmpty(message = "Không được để trống")
    private String service_image;

    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Phải nhập số dương")
    private Integer service_area;

    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Phải nhập số dương")
    private Double service_cost;

    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Phải nhập số dương")
    private Integer service_max_people;

    @NotEmpty(message = "Không được để trống")
    private String service_description;


    private AttachService attachService;

    public ServiceDTO() {
    }

    public ServiceDTO(Integer service_id, String service_name, String service_image, Integer service_area, Double service_cost, Integer service_max_people, String service_description, AttachService attachService) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_image = service_image;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.service_description = service_description;
        this.attachService = attachService;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_image() {
        return service_image;
    }

    public void setService_image(String service_image) {
        this.service_image = service_image;
    }

    public Integer getService_area() {
        return service_area;
    }

    public void setService_area(Integer service_area) {
        this.service_area = service_area;
    }

    public Double getService_cost() {
        return service_cost;
    }

    public void setService_cost(Double service_cost) {
        this.service_cost = service_cost;
    }

    public Integer getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(Integer service_max_people) {
        this.service_max_people = service_max_people;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
