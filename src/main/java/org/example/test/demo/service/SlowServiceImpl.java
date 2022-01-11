package org.example.test.demo.service;

import org.example.test.demo.dto.SlowServiceResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class SlowServiceImpl implements SlowService {

	@Override
	public SlowServiceResponseDTO slowMethod() {
	    try {
	        long time = 10000L;
	        Thread.sleep(time);
	      } catch (InterruptedException e) {
	        throw new IllegalStateException(e);
	      }
	    SlowServiceResponseDTO response = new SlowServiceResponseDTO();
	    response.setResult("OK");
	    return response;
	}

}
