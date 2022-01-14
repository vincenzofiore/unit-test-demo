package org.example.test.demo.service;

import org.example.test.demo.dto.SlowServiceResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlowServiceImplTest {
	
	SlowService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new SlowServiceImpl();
	}

	@Test
	void testLessSlowServiceMethod() throws Exception {
		// given
		
		// when
		SlowServiceResponseDTO actResp = service.lessSlowServiceMethod();
		
		// then
		Assertions.assertNotNull(actResp);
	}

}
