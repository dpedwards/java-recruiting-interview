package com.springboot.webservice.service;

import java.util.List;

import com.springboot.webservice.shared.dto.AddressDTO;

/**
 * 
 * @author dpedwards
 *
 */
public interface AddressService {
	List<AddressDTO> getAddresses(String userId);
    AddressDTO getAddress(String addressId);
}
