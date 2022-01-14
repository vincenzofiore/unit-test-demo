package org.example.test.demo.service;

import org.example.test.demo.dto.SlowServiceResponseDTO;

public interface SlowService {
	
	SlowServiceResponseDTO slowMethod();
	
	SlowServiceResponseDTO lessSlowServiceMethod();

}
