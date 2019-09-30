package com.springboot.webservice.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.webservice.shared.dto.UserDTO;

/**
 * 
 * @author dpedwards
 *
 */
public interface UserService extends UserDetailsService{
	UserDTO createUser(UserDTO user);
	UserDTO getUser(String email);
	UserDTO getUserByUserId(String userId);
	UserDTO updateUser(String userId, UserDTO user);
	void deleteUser(String userId);
	List<UserDTO> getUsers(int page, int limit);
	boolean verifyEmailToken(String token);
	boolean requestPasswordReset(String email);
	boolean resetPassword(String token, String password);
}
