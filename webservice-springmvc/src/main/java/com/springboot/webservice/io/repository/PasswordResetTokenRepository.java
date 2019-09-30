package com.springboot.webservice.io.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.webservice.io.entity.PasswordResetTokenEntity;

/**
 * 
 * @author dpedwards
 *
 */
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetTokenEntity, Long>{
	PasswordResetTokenEntity findByToken(String token);
}
