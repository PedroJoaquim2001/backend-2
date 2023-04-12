package com.projectBackend2.projectBackend.controller.dto;

import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.model.status.AcessStatus;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AdminsDto {
    private UUID id;
    private String name;
    private AcessStatus acessLevel;

    public AdminsDto(AdminsModel adminsModel) {
        this.id = adminsModel.getId();
        this.name = adminsModel.getName();
        this.acessLevel = adminsModel.getAcessLevel();
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

    public static List<AdminsDto> convert(List<AdminsModel> adminsModels){
        return adminsModels.stream().map(AdminsDto::new).collect(Collectors.toList());
    }
}
