package com.exam.msexam.auth.role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoleDTO {
    
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    public static RoleDTO transform(Role role){
        RoleDTO roleDto = new RoleDTO();
        roleDto.setName(role.getName());
        roleDto.setId(role.getId());
        return roleDto;
    }
}