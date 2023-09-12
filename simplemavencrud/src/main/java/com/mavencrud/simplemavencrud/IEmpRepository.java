package com.mavencrud.simplemavencrud;

import java.util.ArrayList;
import java.util.List;

public interface IEmpRepository {
	public List<Employee> getAllEmployees();

	public Employee getEmployeeByEmpNo(int eno);

	public void addEmployee(Employee e);

	public ArrayList<Employee> deleteEmployee(int empno);

	public void updateEmployee(Employee emp);
}