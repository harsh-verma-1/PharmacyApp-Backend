package com.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="user_table")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int UserId;
	private String name;
	private String email;
	private String password;
	private String role;
}
