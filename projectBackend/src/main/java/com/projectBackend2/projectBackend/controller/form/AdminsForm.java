package com.projectBackend2.projectBackend.controller.form;

import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.model.status.AcessStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class AdminsForm {
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String name;
    @NotNull @NotEmpty @Length(min = 1,max = 50)
    private String e_mail;
    @NotNull @NotEmpty @Length(min = 1,max = 20)
    private String password;

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

    public AdminsModel convert(){
        return new AdminsModel(name, e_mail, password);
    }
}
