package com.sample.jee7;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class UserService {
	
	private static final List<User> USERS = Arrays.asList(
			new User("admin", Arrays.asList("admin", "role1")),
			new User("jose", Arrays.asList("admin", "role2")),
			new User("manuel", Arrays.asList("role1", "role2")));
	
	public User findUser(String userName) {
		return USERS.stream().filter(u -> u.getUserName().equals(userName)).findFirst().get();
	}

}
