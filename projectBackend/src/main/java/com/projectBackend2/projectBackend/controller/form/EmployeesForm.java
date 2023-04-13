package com.projectBackend2.projectBackend.controller.form;

import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.model.EmployeesModel;
import com.projectBackend2.projectBackend.model.status.AcessStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class EmployeesForm {
    @NotNull @NotEmpty @Length(min = 1,max = 35)
    private String name;
    @NotNull @NotEmpty @Length(min = 1,max = 50)
    private String e_mail;
    @NotNull @NotEmpty @Length(min = 1,max = 20)
    private String password;
    @NotNull @NotEmpty @Length(min = 1,max = 8)
    private AcessStatus acessLevel;

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


    public EmployeesModel convert(){
        return new EmployeesModel(name, e_mail, password);
    }
}
