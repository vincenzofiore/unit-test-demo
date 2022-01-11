package org.example.test.demo.controller;

import static org.mockito.Mockito.verify;

import org.example.test.demo.controller.SlowController;
import org.example.test.demo.dto.SlowServiceResponseDTO;
import org.example.test.demo.service.SlowService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SlowControllerMockTest {
	
	@Mock
	SlowService service;
	
	@InjectMocks
	SlowController controller = new SlowController();
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void slowApiTest() throws Exception {
		// given
		
		// when
		SlowServiceResponseDTO actResp = controller.slowApi();
		
		// then
		Assertions.assertNotNull(actResp);
		Assertions.assertEquals("OK", actResp.getResult());
		verify(service).slowMethod();
	}

}
