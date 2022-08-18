package com.zee.zee5app.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name = "user_table")
public class User{
	public User( boolean active,LocalDate dob, LocalDate doj, String email,String firstname, String lastname, String password, String userName) {
		
		this.active = active;
		this.dob = dob;
		this.doj = doj;
		this.email = email;
		this.firstName = firstname;
		this.lastName = lastname;
	}
	@Id
	@GenericGenerator(name="userIdGenerator", strategy = "com.zee.zee5app.utils.UserIdGenerator")
	@GeneratedValue(generator = "userIdGenerator")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private LocalDate doj;
	private LocalDate dob;	
	private boolean active;
	
}
