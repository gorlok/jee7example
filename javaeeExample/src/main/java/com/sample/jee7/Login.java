package com.sample.jee7;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@Stateless
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull @Size(min=1, max=30)
	private String userName;
	
	@NotNull @Size(min=1, max=30)
	private String userPassword;

	@Inject
	private User user;
	
	@Inject
	private UserService userService;
	
	@PostConstruct
	public void init() {
		this.userName="";
		this.userPassword="";
	}
	
	public String login() {
		User userDb = userService.findUser(userName);
		if (this.user == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found", null));
			return "";
		}
		this.user.setUserName(userDb.getUserName());
		this.user.setRoles(userDb.getRoles());
		
		this.userName = null;
		this.userPassword = null;
		return "success.xhtml?faces-redirect=true";
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public User getUser() {
		return user;
	}
	
}
