package org.example.springhrm.services;

import org.example.springhrm.entity.Department;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Position;
import org.example.springhrm.form.EmployeeForm;
import org.example.springhrm.repo.DepartmentRepository;
import org.example.springhrm.repo.EmployeeRepository;
import org.example.springhrm.repo.PositionRepository;
import org.example.springhrm.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    PositionRepository positionRepository;

    @Override
    public Response save(EmployeeForm employeeForm) {
        List<Employee> employee = employeeRepository.findByEmail(employeeForm.getEmail());
        Employee newEmployee = employeeForm.mapToEty();
        if (!employee.isEmpty()) {
            return new Response("Employee is already exist.", false);
        }
        Optional<Department> department = departmentRepository.findById(employeeForm.getDepartmentId());
        Optional<Position> position = positionRepository.findById(employeeForm.getPositionId());
        if (!department.isEmpty()) {
          newEmployee.setDepartment(department.get());
        }
        if (!position.isEmpty()) {
          newEmployee.setPosition(position.get());
        }
        employeeRepository.save(newEmployee);
        return new Response("Employee is saved successfully.", true);
    }
}
