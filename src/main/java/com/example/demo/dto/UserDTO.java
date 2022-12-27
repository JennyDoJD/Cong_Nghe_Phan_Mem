package com.example.demo.dto;


import com.example.demo.model.Users;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private Integer user_id;

    @NotEmpty(message = "Không được để trống")
    private String user_name;

    @NotEmpty(message = "Không được để trống")
    private String user_birthday;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]{10,12}$", message = "CMND chưa đúng định dạng")
    private String user_idCard;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(84|0)9([0|1])[0-9]{7}$", message = "SĐT chưa đúng định dạng")
    private String user_phone;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "/^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$", message = "Email chưa đúng định dạng")
    private String user_email;

    @NotEmpty(message = "Không được để trống")
    private String user_address;

    private Users users;

    public UserDTO() {
    }

    public UserDTO(Integer user_id, String user_name, String user_birthday, String user_idCard, String user_phone, String user_email, String user_address, Users users) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_birthday = user_birthday;
        this.user_idCard = user_idCard;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.user_address = user_address;
        this.users = users;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_idCard() {
        return user_idCard;
    }

    public void setUser_idCard(String user_idCard) {
        this.user_idCard = user_idCard;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
