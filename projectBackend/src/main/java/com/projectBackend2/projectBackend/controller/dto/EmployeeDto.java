package com.projectBackend2.projectBackend.controller.dto;

import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.model.EmployeesModel;
import com.projectBackend2.projectBackend.model.status.AcessStatus;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmployeeDto {
    private UUID id;
    private String name;
    private AcessStatus acessLevel;

    public EmployeeDto(EmployeesModel employeesModel) {
        this.id = employeesModel.getId();
        this.name = employeesModel.getName();
        this.acessLevel = employeesModel.getAcessLevel();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AcessStatus getAcessLevel() {
        return acessLevel;
    }

    public static List<EmployeeDto> convert(List<EmployeesModel> employeesModels){
        return employeesModels.stream().map(EmployeeDto::new).collect(Collectors.toList());
    }
}
