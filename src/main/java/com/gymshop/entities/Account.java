package com.gymshop.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	@Id
	String username;
	String password;
	String fullname;
	String email;
	@Column(name = "image")
	String image;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	@JsonIgnore
	
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
	
}
