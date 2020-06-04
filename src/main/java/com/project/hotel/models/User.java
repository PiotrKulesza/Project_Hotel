package com.project.hotel.models;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToMany;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private String userId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = true)
	private Date dateTime;

	@Column(nullable = false)
	private String telephone;

	@Column(nullable = false)
	private String address;

	@ManyToMany
	private Set<Role> roles;
	
	
}
