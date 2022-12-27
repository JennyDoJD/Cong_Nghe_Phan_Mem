package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer service_id;
    private String service_name;
    private String service_image;
    private String service_area;
    private Double service_cost;
    private Integer service_max_people;
    private String service_description;

    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    public Service() {
    }

    public Service(Integer service_id, String service_name, String service_image, String service_area, Double service_cost, Integer service_max_people, String service_description, AttachService attachService) {
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

    public String getService_area() {
        return service_area;
    }

    public void setService_area(String service_area) {
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
