package com.github.iloveulhj.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {
	@Id
	@Column(name = "email", length = 20, nullable = false, updatable = false, unique = true)
	private String email;
	@Column(name = "name", length = 10, nullable = false)
	private String name;
	@Column(name="password", length = 8, nullable = false)
	private String password;

}
