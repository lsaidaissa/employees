package com.example.employes.service.impl;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.employes.model.Criteria;
import com.example.employes.model.Employe;
import com.example.employes.service.EmployeService;
import com.example.employes.service.impl.EmployeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeServiceImplTest {
	
	private List<Employe> listEmployes;
	
	private Set<Employe> listEmployesWithoutDuplicate;
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public EmployeService employeService() {
            return new EmployeServiceImpl();
        }
    }
	
	@Autowired
    private EmployeService employeService;
	
	@Before
	public void initialize() {
		listEmployes = new ArrayList<>();
		this.listEmployes.add(new Employe(1L, "Jobs", "Steve", 5000.0));
		this.listEmployes.add(new Employe(2L, "Ballmer", "Steve", 3000.0));
		this.listEmployes.add(new Employe(3L, "Gates", "Bill", 3000.0));
		this.listEmployes.add(new Employe(4L, "Page", "Larry", 3000.0));
		this.listEmployes.add(new Employe(1L, "Jobs", "Steve", 5000.0));
	}
	
	@Test
	public void getListEmployesWithoutDuplicateById() {
		Criteria.criteria = "id";
		this.listEmployesWithoutDuplicate = new HashSet<>();
		this.listEmployesWithoutDuplicate.add(new Employe(1L, "Jobs", "Steve", 5000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(2L, "Ballmer", "Steve", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(3L, "Gates", "Bill", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(4L, "Page", "Larry", 3000.0));
		
		assertArrayEquals(this.listEmployesWithoutDuplicate.toArray(), this.employeService.deleteDuplicateEmployes(listEmployes).toArray());
	}
	
	@Test
	public void getListEmployesWithoutDuplicateByNom() {
		Criteria.criteria = "nom";
		this.listEmployesWithoutDuplicate = new HashSet<>();
		this.listEmployesWithoutDuplicate.add(new Employe(1L, "Jobs", "Steve", 5000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(2L, "Ballmer", "Steve", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(3L, "Gates", "Bill", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(4L, "Page", "Larry", 3000.0));
		
		assertArrayEquals(this.listEmployesWithoutDuplicate.toArray(), this.employeService.deleteDuplicateEmployes(listEmployes).toArray());
	}
	
	@Test
	public void getListEmployesWithoutDuplicateByPrenom() {
		Criteria.criteria = "prenom";
		this.listEmployesWithoutDuplicate = new HashSet<>();
		this.listEmployesWithoutDuplicate.add(new Employe(1L, "Jobs", "Steve", 5000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(3L, "Gates", "Bill", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(4L, "Page", "Larry", 3000.0));
		
		assertArrayEquals(this.listEmployesWithoutDuplicate.toArray(), this.employeService.deleteDuplicateEmployes(listEmployes).toArray());
	}
	
	@Test
	public void getListEmployesWithoutDuplicateBySalaire() {
		Criteria.criteria = "salaire";
		this.listEmployesWithoutDuplicate = new HashSet<>();
		this.listEmployesWithoutDuplicate.add(new Employe(1L, "Jobs", "Steve", 5000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(2L, "Ballmer", "Steve", 3000.0));
		
		assertArrayEquals(this.listEmployesWithoutDuplicate.toArray(), this.employeService.deleteDuplicateEmployes(listEmployes).toArray());
	}

}
