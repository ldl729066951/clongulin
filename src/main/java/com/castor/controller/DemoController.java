package com.castor.controller;

import com.castor.database.entities.Demo;
import com.castor.database.repositories.DemoRepository;
import com.castor.dtos.DemoLombok;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoRepository demoRepository;

	@GetMapping("/hello")
	public Object demo(){
		log.info("{}, nishuone","KO");
		List<Demo> demos = demoRepository.findAllByName("Scala");

		demos.stream().forEach(System.out::println);
		return new DemoLombok("castor", 12);
	}

}
