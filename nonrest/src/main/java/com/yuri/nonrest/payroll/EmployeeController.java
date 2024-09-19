package com.yuri.nonrest.payroll;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private final EmployeeRepository repository;
	
	
	EmployeeController(EmployeeRepository rep){
		this.repository = rep;
	}
	
	
	
	@GetMapping("/employees")
	List<Employee> all(){
		return repository.findAll();
	}
	
	
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmp) {
		return repository.save(newEmp);
	}
	

	
	@GetMapping("/employees/{id}")
	Employee one (@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	
	
	@PutMapping("employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmp, @PathVariable long id) {
		
		Employee emp = repository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException(id));
		
		emp.setName(newEmp.getName());
		emp.setRole(newEmp.getRole());
		return repository.save(emp);
	}
	
	
	
	@DeleteMapping("/employess/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
