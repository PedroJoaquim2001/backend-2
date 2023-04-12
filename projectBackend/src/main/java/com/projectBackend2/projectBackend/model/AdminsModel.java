package com.projectBackend2.projectBackend.model;

import com.projectBackend2.projectBackend.model.status.AcessStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ADMINS")
public class AdminsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 35)
    private String name;
    @Column(nullable = false, unique = true, length = 50)
    private String e_mail;
    @Column(nullable = false, unique = true, length = 20)
    private String password;
    @Column(nullable = false)
    private LocalDateTime createdDate;
    @Column(nullable = false)
    private AcessStatus acessLevel;

    public AdminsModel(){

    }

    public AdminsModel(String name, String e_mail, String password, AcessStatus acessLevel) {
        this.name = name;
        this.e_mail = e_mail;
        this.password = password;
        this.acessLevel = acessLevel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public AcessStatus getAcessLevel() {
        return acessLevel;
    }

    public void setAcessLevel(AcessStatus acessLevel) {
        this.acessLevel = acessLevel;
    }
}
