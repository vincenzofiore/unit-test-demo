package org.example.test.demo.controller;

import org.example.test.demo.dto.SlowServiceResponseDTO;
import org.example.test.demo.service.SlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class SlowController {
	
	@Autowired
	private SlowService service;

	@GetMapping(path = "/slow")
	public SlowServiceResponseDTO slowApi() {
		return service.slowMethod();
	}

}
