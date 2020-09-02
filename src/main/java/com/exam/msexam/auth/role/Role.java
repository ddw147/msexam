package com.exam.msexam.auth.role;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;   
    
}