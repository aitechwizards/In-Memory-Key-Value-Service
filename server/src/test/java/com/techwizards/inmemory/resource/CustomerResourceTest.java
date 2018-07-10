package com.techwizards.inmemory.resource;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.techwizards.inmemory.service.CustomerService;
import com.techwizards.inmemory.to.CustomerDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerResource.class, secure = false)
public class CustomerResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public final void testGetById() throws Exception {
		CustomerDTO cst = new CustomerDTO(new Long(1234), "TestData");
		when(customerService.put(cst)).thenReturn(cst);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/techwizards/doc/1234");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("FFF:" + result.getResponse().getContentAsString());
		String expected = "{keyId:1234,FullName:TestData}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	/*
	 * @Test public final void testGetAll() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testPut() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testPutList() { fail("Not yet implemented"); // TODO
	 * }
	 * 
	 * @Test public final void testDelete() { fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testDeleteAll() { fail("Not yet implemented"); //
	 * TODO }
	 */
}
