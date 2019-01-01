package com.example.employes.service;

import java.util.List;
import java.util.Set;

import com.example.employes.model.Employe;

public interface EmployeService {
	Set<Employe> deleteDuplicateEmployes(List<Employe> listEmployes, String criteria) throws NoSuchFieldException, SecurityException;
}
