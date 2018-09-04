package com.castor.controller;

import com.castor.annotations.LocalLock;
import com.castor.database.entities.Demo;
import com.castor.database.repositories.DemoRepository;
import com.castor.dtos.DemoLombok;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoRepository demoRepository;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Serializable> redisCacheTemplate;

	@GetMapping("/hello")
	public Object demo(){
		log.info("{}, nishuone","KO");
		List<Demo> demos = demoRepository.findAllByName("Scala");
		stringRedisTemplate.opsForValue().set("castor::name", "castor");
		redisCacheTemplate.opsForValue().set("castor", new DemoLombok( "abc", 20));
		demos.stream().forEach(System.out::println);
		return new DemoLombok("castor", 12);
	}

	@LocalLock(key = "book:arg[0]")
	@GetMapping
	public String query(@RequestParam String token) {
		return "success - " + token;
	}

}
