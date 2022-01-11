package org.example.test.demo.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.example.test.demo.controller.SlowController;
import org.example.test.demo.dto.SlowServiceResponseDTO;
import org.example.test.demo.service.SlowService;
import org.example.test.demo.service.SlowServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class SlowControllerSpyTest {
	
	@Spy
	SlowService service = new SlowServiceImpl();
	
	@InjectMocks
	SlowController controller = new SlowController();
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void slowApiTest() throws Exception {
		// given
		SlowServiceResponseDTO resp = new SlowServiceResponseDTO();
		resp.setResult("KO");
		when(service.slowMethod()).thenReturn(resp);
		
		// when
		SlowServiceResponseDTO actResp = controller.slowApi();
		
		// then
		Assertions.assertNotNull(actResp);
		Assertions.assertEquals("OK", actResp.getResult());
		verify(service).slowMethod();
	}

}
