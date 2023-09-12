package com.mavencrud.simplemavencrud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {
	private List<Employee> emplist = new ArrayList<Employee>();

	@Override
	public List<Employee> getAllEmployees() {

		// Create some employees and add to the list
		if (emplist.size() == 0) {
			emplist.add(new Employee(1001, 10, "Mahesh", "Manager", 19000.00));
			emplist.add(new Employee(1002, 20, "Nareesh", "Developer", 12000.00));
			emplist.add(new Employee(1003, 30, "Suresh", "Tester", 10000.00));
			emplist.add(new Employee(1004, 10, "Rajesh", "DBA", 15000.00));
			emplist.add(new Employee(1005, 20, "Sujesh", "admin", 10000.00));
			emplist.add(new Employee(1006, 30, "Somesh", "HR", 7000.00));
		}
		return emplist;

	}

	public Employee getEmployeeByEmpNo(int eno) {
		for (Employee e : emplist) {
			if (e.getEmpNo() == eno)
				return e;
		}
		return null;
	}

	public void addEmployee(Employee e) {
		emplist.add(e);
	}

	public ArrayList<Employee> deleteEmployee(int empno) {
		Employee emp = getEmployeeByEmpNo(empno);
		emplist.remove(emp);
		return (ArrayList<Employee>) emplist;
	}

	public void updateEmployee(Employee emp) {
		deleteEmployee(emp.getEmpNo());
		emplist.add(emp);
	}
}
