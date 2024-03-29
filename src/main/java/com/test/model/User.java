package com.test.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "tuser")
public class User implements Serializable {
	private String id;
	private String username;
	private String password;
	private Date regtime;
	
	public User() {
	}

	public User(String id, Date regtime, String username, String password) {
		super();
		this.id = id;
		this.regtime = regtime;
		this.username = username;
		this.password = password;
	}

	@Id  
    @Column(name = "id", nullable = false, length = 36)  
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)  
    @Column(name = "regtime", length = 7) 
	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	@Column(name = "username", unique = false, nullable = false, length = 100)  
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="password",nullable=false,length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
