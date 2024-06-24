package org.example.springhrm.services;

import org.example.springhrm.form.EmployeeForm;
import org.example.springhrm.utils.Response;

public interface EmployeeService {
    Response save(EmployeeForm employeeForm);
}
