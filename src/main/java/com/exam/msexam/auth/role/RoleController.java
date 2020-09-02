
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getAll();
    }

    @GetMapping("/{roleId}")
    public RoleDTO getRole(@PathVariable Long roleId){
        return RoleDTO.transform(roleService.findRole(roleId));
    }

    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        roleService.delete(roleId);
    }

    @PostMapping
    public Role addRole(@Valid @RequestBody RoleDTO roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        return roleService.saveRole(role);
    }

    @PutMapping("/{roleId}")
    public Role addRole(@Valid @RequestBody RoleDTO roleDto, @RequestParam Long roleId) {
        Role role = roleService.findRole(roleId);
        role.setName(roleDto.getName());
        return roleService.saveRole(role);
    }



}
