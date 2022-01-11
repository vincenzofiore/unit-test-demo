package org.example.test.demo.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.example.test.demo.dto.SlowServiceResponseDTO;
import org.example.test.demo.service.SlowService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

class SlowControllerMvcTest {
	
	MockMvc mockMvc;
	
	@Mock
	SlowService service;
	
	@InjectMocks
	SlowController controller = new SlowController();
	
	final String url = "/api/slow";
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void slowApiTest() throws Exception {
		// given
		SlowServiceResponseDTO resp = new SlowServiceResponseDTO();
		resp.setResult("KO");
		
		// when
	    MockHttpServletRequestBuilder request = get(url);
	    this.mockMvc //
	        .perform(request) //
	        .andExpect(status().is2xxSuccessful()) //
	        .andExpect(content().string(asJsonString(resp)));
		
		// then
		verify(service).slowMethod();
	}
	
	private String asJsonString(final Object obj) throws Exception {
		return new ObjectMapper().writeValueAsString(obj);
	}

}
