/**
 * 
 */
package com.techwizards.inmemory.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techwizards.inmemory.to.CustomerDTO;

/**
 * @author s727953
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	private static final Long Customer_Id = new Long(78);
	private static final Long Customer_Id_1 = new Long(76);

	@Before
	public void setupFindAll() {
		CustomerDTO objCustomer1 = new CustomerDTO(Customer_Id, "Bharat");
		CustomerDTO objCustomer2 = new CustomerDTO(Customer_Id_1, "Singh");
		List<CustomerDTO> entities = new ArrayList<>();
		entities.add(objCustomer1);
		entities.add(objCustomer2);
		customerRepository.saveAll(entities);
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.repository.CrudRepository#findAll()}.
	 */

	@Test
	public final void testFindAll() {
		Iterable<CustomerDTO> expected = customerRepository.findAll();
		assertThat(expected).isNotNull();
		assertThat(expected).isNotEmpty();
		long Size = StreamSupport.stream(expected.spliterator(), false).count();
		assertThat(Size).isGreaterThanOrEqualTo(2);
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.repository.CrudRepository#findById(java.lang.Object)}.
	 */
	@Test
	public final void testFindById() {
		CustomerDTO actual = new CustomerDTO(Customer_Id, "Java User");
		customerRepository.save(actual);

		Optional<CustomerDTO> expected = customerRepository.findById(actual.getKeyId());
		assertThat(expected.isPresent()).isEqualTo(true);
		assertThat(expected.get().getKeyId()).isEqualTo(actual.getKeyId());
		assertThat(expected.get().getFullName()).isEqualTo(actual.getFullName());
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.repository.CrudRepository#save(S)}.
	 */
	@Test
	public final void testSave() {
		CustomerDTO actual = new CustomerDTO(Customer_Id, "Bharat Singh");
		customerRepository.save(actual);
		Optional<CustomerDTO> expected = customerRepository.findById(actual.getKeyId());
		assertThat(expected.isPresent()).isEqualTo(true);
		assertThat(expected.get().getFullName()).isEqualTo(actual.getFullName());
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.repository.CrudRepository#saveAll(java.lang.Iterable)}.
	 */
	@Test
	public final void testSaveAll() {
		CustomerDTO objCustomer1 = new CustomerDTO(new Long(34), "Bharat");
		CustomerDTO objCustomer2 = new CustomerDTO(new Long(56), "Singh");
		List<CustomerDTO> entities = new ArrayList<>();
		entities.add(objCustomer1);
		entities.add(objCustomer2);
		customerRepository.saveAll(entities);

		Iterable<CustomerDTO> expected = customerRepository.findAll();
		assertThat(expected).isNotNull();
		assertThat(expected).isNotEmpty();
		long expectedSize = StreamSupport.stream(expected.spliterator(), false).count();
		assertThat(expectedSize).isGreaterThanOrEqualTo(4);

	}

	@Before
	public void setup() {
		CustomerDTO customer = new CustomerDTO(Customer_Id, "Bharat");
		customerRepository.save(customer);
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.repository.CrudRepository#delete(java.lang.Object)}.
	 */
	@Test
	public final void testDelete() {

		Iterable<CustomerDTO> actual = customerRepository.findAll();
		customerRepository.deleteById(Customer_Id);
		Iterable<CustomerDTO> expected = customerRepository.findAll();

		long actualSize = StreamSupport.stream(actual.spliterator(), false).count();
		long expectedSize = StreamSupport.stream(expected.spliterator(), false).count();
		System.err.println(" actualSize " + actualSize);
		System.err.println(" expectedSize " + expectedSize);

		expected.forEach(x -> {
			System.err.println(x);
			assertThat(x.getKeyId()).isEqualTo(76);
		});
		assertThat(actualSize).isGreaterThanOrEqualTo(expectedSize);

	}

	@Before
	public void setupDeleteAll() {
		CustomerDTO customer = new CustomerDTO(Customer_Id, "Bharat");
		CustomerDTO customer1 = new CustomerDTO(Customer_Id_1, "Singh");
		List<CustomerDTO> entities = new ArrayList<>();
		entities.add(customer);
		entities.add(customer1);
		customerRepository.saveAll(entities);
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.repository.CrudRepository#deleteAll()}.
	 */
	@Test
	public final void testDeleteAll() {
		customerRepository.deleteAll();
		Iterable<CustomerDTO> expectedCustomerList = customerRepository.findAll();
		assertThat(expectedCustomerList).isEmpty();
	}

}
