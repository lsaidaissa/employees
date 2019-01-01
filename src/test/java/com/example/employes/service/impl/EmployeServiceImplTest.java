package com.example.employes.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

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
		this.listEmployes.add(new Employe(1l, "Jobs", "Steve", 5000.0));
		this.listEmployes.add(new Employe(2l, "Ballmer", "Steve", 3000.0));
		this.listEmployes.add(new Employe(3l, "Gates", "Bill", 3000.0));
		this.listEmployes.add(new Employe(4l, "Page", "Larry", 3000.0));
		this.listEmployes.add(new Employe(1l, "Jobs", "Steve", 5000.0));
	}

	@Test
	public void getListEmployesWithoutDuplicateById() throws NoSuchFieldException, SecurityException {
		this.listEmployesWithoutDuplicate = new HashSet<>();
		this.listEmployesWithoutDuplicate.add(new Employe(1l, "Jobs", "Steve", 5000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(2l, "Ballmer", "Steve", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(3l, "Gates", "Bill", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(4l, "Page", "Larry", 3000.0));

		// this.employeService.deleteDuplicateEmployes(listEmployes, "id")
		// .forEach(e -> System.out.println(e.getNom()));

		// assertTrue(this.listEmployesWithoutDuplicate
		// .equals(this.employeService.deleteDuplicateEmployes(listEmployes, "id")));
		assertTrue(4 == this.employeService.deleteDuplicateEmployes(listEmployes, "id").size());
	}

	@Test
	public void getListEmployesWithoutDuplicateByNom() throws NoSuchFieldException, SecurityException {
		this.listEmployesWithoutDuplicate = Stream.of(new Employe(1l, "Jobs", "Steve", 5000.0), 
													  new Employe(2l, "Ballmer", "Steve", 3000.0),
													  new Employe(3l, "Gates", "Bill", 3000.0),
													  new Employe(4l, "Page", "Larry", 3000.0))
											.collect(Collectors.toSet());
		
		//assertTrue(this.listEmployesWithoutDuplicate.equals(
				//this.employeService.deleteDuplicateEmployes(listEmployes, "nom")));
		assertTrue(4 == this.employeService.deleteDuplicateEmployes(listEmployes, "nom").size());
	}

	@Test
	public void getListEmployesWithoutDuplicateByPrenom() throws NoSuchFieldException, SecurityException {
		this.listEmployesWithoutDuplicate = new HashSet<>();
		this.listEmployesWithoutDuplicate.add(new Employe(1l, "Jobs", "Steve", 5000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(3l, "Gates", "Bill", 3000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(4l, "Page", "Larry", 3000.0));

		//assertTrue(this.listEmployesWithoutDuplicate
			//	.equals(this.employeService.deleteDuplicateEmployes(listEmployes, "prenom")));
		assertTrue(3 == this.employeService.deleteDuplicateEmployes(listEmployes, "prenom").size());
	}

	@Test
	public void getListEmployesWithoutDuplicateBySalaire() throws NoSuchFieldException, SecurityException {
		this.listEmployesWithoutDuplicate = new HashSet<>();
		this.listEmployesWithoutDuplicate.add(new Employe(1l, "Jobs", "Steve", 5000.0));
		this.listEmployesWithoutDuplicate.add(new Employe(2l, "Ballmer", "Steve", 3000.0));

		// assertArrayEquals(this.listEmployesWithoutDuplicate.toArray(),
		// this.employeService.deleteDuplicateEmployes(listEmployes,
		// "salaire").toArray());
		assertTrue(2 == this.employeService.deleteDuplicateEmployes(listEmployes, "salaire").size());
	}

}
