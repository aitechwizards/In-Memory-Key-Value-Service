/**
 * 
 */
package com.techwizards.inmemory.repository;

import org.springframework.data.repository.CrudRepository;

import com.techwizards.inmemory.to.CustomerDTO;

/**
 * @author TechWizards
 *
 */
public interface CustomerRepository extends CrudRepository<CustomerDTO, Long> {

	// public interface CustomerRepository extends KeyValueRepository<CustomerDTO,
	// Long>, CustomerRepositoryCustom {

}
