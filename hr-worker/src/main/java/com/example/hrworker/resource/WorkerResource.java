package com.example.hrworker.resource;

import java.util.List;

import org.apache.catalina.webresources.WarResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkRepository;

@RefreshScope
@RestController
@RequestMapping(value= "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WarResource.class);
	
//	@Value("${test.config}")
//	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = this.repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/configs")
	public ResponseEntity<Void> getConfig() {
	//	logger.info("CONFIG:" + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id)  {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = this.repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
