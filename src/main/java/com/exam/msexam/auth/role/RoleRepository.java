package com.exam.msexam.auth.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    
    @Modifying
    @Query(value="UPDATE role r SET r.deleted_date = now() WHERE r.id = :roleId ",nativeQuery = true)
    public void deleteById(@Param("roleId") Long roleId);

}