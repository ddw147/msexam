
package com.exam.msexam.auth.role;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> getRoles() {
        return roleService.getAll();
    }

    @GetMapping("/{roleId}")
    public RoleDTO getRole(@PathVariable Long roleId){
        return roleService.findRole(roleId);
    }

    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
    }

    @PutMapping("/{roleId}/restore")
    public void restoreRole(@PathVariable Long roleId) {
        roleService.restoreRole(roleId);
    }

    @PostMapping
    public RoleDTO addRole(@Valid @RequestBody RoleDTO roleDto) {
        return roleService.saveRole(roleDto);
    }

    @PutMapping("/{roleId}")
    public RoleDTO updateRole(@Valid @RequestBody RoleDTO roleDto, @PathVariable Long roleId) {
        return roleService.updateRole(roleDto,roleId);
    }
}
