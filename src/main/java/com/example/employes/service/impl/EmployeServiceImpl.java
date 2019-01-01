package com.example.employes.service.impl;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.employes.model.Employe;
import com.example.employes.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	// first solution, using distinctByKey
	/*
	 * @Override public Set<Employe> deleteDuplicateEmployes(List<Employe>
	 * listEmployes, String criteria) { return
	 * listEmployes.stream().filter(distinctByKey(criteria.equals("id") ?
	 * Employe::getId : // criteria // is id // // id (criteria.equals("nom") ?
	 * Employe::getNom : // criteria is nom (criteria.equals("prenom") ?
	 * Employe::getPrenom : // criteria is prenom (criteria.equals("salaire") ?
	 * Employe::getSalaire : null))))) .collect(Collectors.toSet()); }
	 */

	// second solution, without a function using collecting and then
	/*
	 * @Override public Set<Employe> deleteDuplicateEmployes(List<Employe>
	 * listEmployes, String criteria) { return
	 * listEmployes.stream().collect(collectingAndThen(toCollection(() -> new
	 * TreeSet<>(comparingInt(Employee::getId))), HashSet::new)); }
	 */
	// third solution using a distinctKeyField

	/*@Override
	public Set<Employe> deleteDuplicateEmployes(List<Employe> listEmployes, String criteria) {
		return listEmployes.stream().filter(distinctByField(criteria.equals("id") ? Employe::getId : // criteria // is
																										// id // // id
				(criteria.equals("nom") ? Employe::getNom : // criteria is nom
						(criteria.equals("prenom") ? Employe::getPrenom : // criteria is prenom
								(criteria.equals("salaire") ? Employe::getSalaire : null)))))
				.collect(Collectors.toSet());
	}*/
	// forth solution, using comparing and then
	@Override
	public Set<Employe> deleteDuplicateEmployes(List<Employe> listEmployes, String criteria) {
		if (criteria.equals("id"))
			return listEmployes.stream().collect(Collectors
					.collectingAndThen(
							Collectors.toCollection(
									() -> new TreeSet<>(Comparator.comparing(Employe::getId))), 
							HashSet::new));
		else if (criteria.equals("nom"))
			return listEmployes.stream().collect(Collectors
				.collectingAndThen(
						Collectors.toCollection(
								() -> new TreeSet<>(Comparator.comparing(Employe::getNom))), 
						HashSet::new));
		else if (criteria.equals("prenom"))
			return listEmployes.stream().collect(Collectors
				.collectingAndThen(
						Collectors.toCollection(
								() -> new TreeSet<>(Comparator.comparing(Employe::getPrenom))), 
						HashSet::new));
		else if (criteria.equals("salaire"))
			return listEmployes.stream().collect(Collectors
				.collectingAndThen(
						Collectors.toCollection(
								() -> new TreeSet<>(Comparator.comparing(Employe::getSalaire))), 
						HashSet::new));
		return listEmployes.stream().collect(Collectors.toSet());
	}

	// Utility function used in the first solution
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	// Utility function used in the third solution
	public static <T> Predicate<T> distinctByField(Function<? super T, Object> keyExtractor) {
		Set<Object> exist = new HashSet<>();
		return t -> exist.add(keyExtractor.apply(t));
	}
}
