package com.example.employes.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.employes.model.Employe;
import com.example.employes.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService{

	@Override
	public Set<Employe> deleteDuplicateEmployes(List<Employe> listEmployes) {
		return listEmployes.stream().distinct().collect(Collectors.toSet());
	}


}
