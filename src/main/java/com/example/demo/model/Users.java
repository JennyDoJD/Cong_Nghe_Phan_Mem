package com.example.demo.model;


import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column
    private String user_name;

    @Column
    private String user_birthday;

    @Column
    private String user_idCard;

    @Column
    private String user_phone;

    @Column
    private String user_email;

    @Column
    private String user_address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    public Users() {
    }

    public Users(Integer user_id, String user_name, String user_birthday, String user_idCard, String user_phone, String user_email, String user_address, Account account) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_birthday = user_birthday;
        this.user_idCard = user_idCard;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.user_address = user_address;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
