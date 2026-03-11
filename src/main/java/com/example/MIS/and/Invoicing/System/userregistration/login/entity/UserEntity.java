package com.example.MIS.and.Invoicing.System.userregistration.login.entity;

import com.example.MIS.and.Invoicing.System.userregistration.login.Role;
import com.example.MIS.and.Invoicing.System.userregistration.login.Status;
import jakarta.persistence.*;
import jdk.jshell.Snippet;

@Entity
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_Id;
    @Column(name = "full-name",nullable = false)
    private String full_name;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(name="password_hash",nullable = false)
    private String password_hash;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    public UserEntity(){

    }
    public UserEntity(Integer user_Id,String full_name,String email,String password_hash,String role){
        this.user_Id=user_Id;
        this.full_name=full_name;
        this.email=email;
        this.password_hash=password_hash;
    }
    //Getters
    public Integer getUser_Id() {
        return user_Id;
    }
    public String getFull_name() {
        return full_name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword_hash() {
        return password_hash;
    }
    //Setters
    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
