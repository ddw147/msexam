package com.exam.msexam.auth.role;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;


    public List<Role> getAll(){
        return roleRepo.findAll();
    }

    
}