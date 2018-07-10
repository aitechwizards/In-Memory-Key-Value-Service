package com.techwizards.inmemory.resource;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techwizards.inmemory.service.CustomerService;
import com.techwizards.inmemory.to.CustomerDTO;

/**
 * @author techwizards
 * @Desc : This application will we used for thread Safe in memory service
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/api/techwizards")
public class CustomerResource {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerResource.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * @ This will Fetch document on the bases of Doc ID
	 * 
	 * @param docId
	 */
	@GetMapping("/doc/{docId}")
	public ResponseEntity<Optional<CustomerDTO>> getById(@PathVariable long docId) {
		return new ResponseEntity<>(customerService.get(docId), HttpStatus.OK);
	}

	/**
	 * @ This will Fetch All the Document
	 * 
	 * @param docId
	 */

	@GetMapping(path = "/doc/")
	public ResponseEntity<Iterable<CustomerDTO>> getAll() {
		return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
	}

	/**
	 * @ This will add specific document object into DB
	 * 
	 * @param docId
	 */

	@PutMapping(path = "/doc/")
	public void put(@RequestBody CustomerDTO dto) {
		LOG.info(dto.toString());
		customerService.put(dto);

	}
	
	 /**
	 * @ This will add list of document object into DB
	 *
	 * @param docId
	 */
	
//	 @PutMapping(path = "/doc/")
//	 public void putAll(@RequestBody List<CustomerDTO> dtos) {
//	 customerService.putAll(dtos);
//	 }

	/**
	 * @ This will remove document object from DB for specific DocID
	 * 
	 * @param docId
	 */
	@DeleteMapping(path = "/doc/{docId}")
	public void delete(@PathVariable long docId) {
		customerService.delete(docId);

	}

	/**
	 * @ This will remove all the document object from DB
	 * 
	 * @param docId
	 */
	@DeleteMapping(path = "/doc/")
	public void deleteAll() {
		customerService.deleteAll();

	}

}
