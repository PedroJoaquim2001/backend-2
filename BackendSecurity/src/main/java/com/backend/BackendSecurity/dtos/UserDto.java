package com.backend.BackendSecurity.dtos;

import com.backend.BackendSecurity.models.enums.AcessStatus;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserDto {
    @NotBlank @Length(min = 1,max = 35)
    private String username;
    @NotBlank @Length(min = 1,max = 50)
    private String e_mail;
    @NotBlank @Length(min = 1,max = 65)
    private String password;
    @NotBlank
    private AcessStatus acessLevel = AcessStatus.LIMITED;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAcessLevel() {
        return acessLevel.toString();
    }

    public void setAcessLevel(AcessStatus acessLevel) {
        this.acessLevel = acessLevel;
    }
}
