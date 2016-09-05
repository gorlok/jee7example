package com.sample.jee7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String userName;
	
	private List<String> roles = new ArrayList<>();
	
	public User() {
	}
	
	public User(String userName, List<String> roles) {
		super();
		this.userName = userName;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public List<String> getRoles() {
		return roles;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
