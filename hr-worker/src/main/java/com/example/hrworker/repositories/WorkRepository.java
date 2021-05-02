package com.example.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrworker.entities.Worker;

public interface WorkRepository extends JpaRepository<Worker, Long>{

}
