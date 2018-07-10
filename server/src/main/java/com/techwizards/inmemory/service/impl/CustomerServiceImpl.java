/**
 * 
 */
package com.techwizards.inmemory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwizards.inmemory.repository.CustomerRepository;
import com.techwizards.inmemory.service.CustomerService;
import com.techwizards.inmemory.to.CustomerDTO;

/**
 * @author TechWizards
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO put(CustomerDTO customerDTO) {
		CustomerDTO targetDto = new CustomerDTO();
		BeanUtils.copyProperties(customerDTO, targetDto);
		return customerRepository.save(customerDTO);

	}

	@Override
	public Iterable<CustomerDTO> putAll(List<CustomerDTO> employee) {
		return customerRepository.saveAll(employee);

	}

	@Override
	public Optional<CustomerDTO> get(Long id) {
		return customerRepository.findById(new Long(id));
	}

	@Override
	public Iterable<CustomerDTO> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		CustomerDTO dto = new CustomerDTO(id);
		customerRepository.delete(dto);
	}

	@Override
	public void deleteAll() {
		customerRepository.deleteAll();

	}

}
