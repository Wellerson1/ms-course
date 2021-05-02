package com.example.hrworker.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkRepository;

@RestController
@RequestMapping(value= "/workers")
public class WorkerResource {

	@Autowired
	private WorkRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = this.repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker worker = this.repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
