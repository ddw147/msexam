package com.exam.msexam.auth.role;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepo;

  public List<RoleDTO> getAll() {

    List<Role> roles = roleRepo.findAll();
    return roles.stream().map(RoleDTO::transform).collect(Collectors.toList());

  }

  public RoleDTO findRole(Long id) {
    return RoleDTO.transform(roleRepo.getOne(id));
  }

  public RoleDTO saveRole(RoleDTO roleDto) {
    Role role = new Role();
    role.setName(roleDto.getName());
    return RoleDTO.transform(roleRepo.save(role));
  }

  public RoleDTO updateRole(RoleDTO roleDto, Long roleId) {
    Role role = roleRepo.getOne(roleId);
    role.setName(roleDto.getName());
    return RoleDTO.transform(roleRepo.save(role));
  }

  public void deleteRole(Long roleId) {
    Role role = roleRepo.getOne(roleId);
    role.setIsActive(false);
    roleRepo.save(role);
  }
  public void restoreRole(Long roleId) {
    Role role = roleRepo.getOne(roleId);
    role.setIsActive(true);
    roleRepo.save(role);
  }

}
