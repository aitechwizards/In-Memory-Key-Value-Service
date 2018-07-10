/**
 * 
 */
package com.techwizards.inmemory.service;

import java.util.List;
import java.util.Optional;

import com.techwizards.inmemory.to.CustomerDTO;

/**
 * @author TechWizards
 *
 */
public interface CustomerService {

	CustomerDTO put(CustomerDTO customerDTO);

	Iterable<CustomerDTO> putAll(List<CustomerDTO> employee);

	Optional<CustomerDTO> get(Long id);

	Iterable<CustomerDTO> getAll();

	void delete(Long id);

	void deleteAll();

}
