package com.example.employes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.employes.EmployesApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesApplicationTest {

	@Test
	public void contextLoads() {
		EmployesApplication.main(new String[] {});
	}

}
