package com.springboot.webservice.io.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.webservice.io.entity.AddressEntity;
import com.springboot.webservice.io.entity.UserEntity;

/**
 * 
 * @author dpedwards
 *
 */
@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
	List<AddressEntity> findAllByUserDetails(UserEntity userEntity);
	AddressEntity findByAddressId(String addressId);
}
