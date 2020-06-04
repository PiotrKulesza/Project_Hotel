package com.project.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    private String roleId;

    @Column(nullable = false)
    private String roleName;

}
