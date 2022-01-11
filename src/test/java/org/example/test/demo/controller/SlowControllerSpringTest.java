package org.example.test.demo.controller;

import org.example.test.demo.controller.SlowController;
import org.example.test.demo.dto.SlowServiceResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SlowControllerSpringTest {
	
	@Autowired
	SlowController controller;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void slowApiTest() throws Exception {
		// given
		
		// when
		SlowServiceResponseDTO actResp = controller.slowApi();
		
		// then
		Assertions.assertNotNull(actResp);
		Assertions.assertEquals("OK", actResp.getResult());
	}

}
