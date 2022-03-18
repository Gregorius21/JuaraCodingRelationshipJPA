package com.juaracoding.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long customerId;
	private String firstName;
	private String lastName;
	private String noHp;
	private String address;
	private String email;
	private Date birthdate;
	private String username;
	private String password;
}
