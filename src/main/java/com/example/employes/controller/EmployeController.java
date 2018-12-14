package com.example.employes.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employes.model.Criteria;
import com.example.employes.model.Employe;
import com.example.employes.service.EmployeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employes")
public class EmployeController {

	private EmployeService employeService;

	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}

	@PostMapping("/deleteDuplicate/{criteria}")
	public ResponseEntity<Set<Employe>> deleteDuplicateEmployes(@RequestBody List<Employe> listEmployes,
			@PathVariable String criteria) {
		Criteria.criteria = criteria;
		return ResponseEntity.ok().body(this.employeService.deleteDuplicateEmployes(listEmployes));
	}

}
