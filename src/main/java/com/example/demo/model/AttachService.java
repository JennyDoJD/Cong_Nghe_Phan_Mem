package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer attach_service_id;
    private String attach_service_name;
    private String attach_service_image;
    private Double attach_service_cost;

    public AttachService() {
    }

    public AttachService(Integer attach_service_id, String attach_service_name, String attach_service_image, Double attach_service_cost) {
        this.attach_service_id = attach_service_id;
        this.attach_service_name = attach_service_name;
        this.attach_service_image = attach_service_image;
        this.attach_service_cost = attach_service_cost;
    }

    public Integer getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(Integer attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }

    public String getAttach_service_image() {
        return attach_service_image;
    }

    public void setAttach_service_image(String attach_service_image) {
        this.attach_service_image = attach_service_image;
    }

    public Double getAttach_service_cost() {
        return attach_service_cost;
    }

    public void setAttach_service_cost(Double attach_service_cost) {
        this.attach_service_cost = attach_service_cost;
    }
}
