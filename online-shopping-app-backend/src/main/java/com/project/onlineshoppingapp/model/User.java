package com.project.onlineshoppingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Entity
public class User {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) //I'm using Custom Id generator so I've commented this line
	private Long userId;
	private String name;
	private String phone;
	private String email;	
	private String password;
	private String role="USER";

	

}
