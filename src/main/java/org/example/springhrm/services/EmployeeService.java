package org.example.springhrm.services;

import org.example.springhrm.entity.Employee;
import org.example.springhrm.form.EmployeeForm;
import org.example.springhrm.utils.Response;

import java.util.List;

public interface EmployeeService {
    Response save(EmployeeForm employeeForm);

    Response edit(EmployeeForm employeeForm);

    List<Employee> findEmpByLevel();
}
