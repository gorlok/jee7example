package com.sample.jee7;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Named
@Stateless
@Path("/")
public class HelloRest {
	
	@Inject
	private User user;
	
	@GET
	@Path("hello")
	public String hello() {
		return "Hello " + user.getUserName();
	}

}
