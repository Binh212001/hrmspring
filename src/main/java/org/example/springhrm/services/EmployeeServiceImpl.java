package org.example.springhrm.services;

import jakarta.servlet.http.HttpSession;
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

    @Override
    public Response edit(EmployeeForm employeeForm) {
        Optional<Employee> employee = employeeRepository.findById(employeeForm.getId());
        if (employee.isEmpty()) {
            return new Response("Cannot find employee", false);
        }
        employee.get().setAddress(employeeForm.getAddress());
        employee.get().setDateOfBirth(employeeForm.getDateOfBirth());
        employee.get().setEmail(employeeForm.getEmail());
        employee.get().setFirstName(employeeForm.getFirstName());
        employee.get().setGender(employeeForm.getGender());
        employee.get().setGpa(employeeForm.getGpa());
        employee.get().setGraduation(employeeForm.getGraduation());
        employee.get().setHireDate(employeeForm.getHireDate());
        employee.get().setLastName(employeeForm.getLastName());
        employee.get().setPassword(employeeForm.getPassword());
        employee.get().setPhone(employeeForm.getPhone());
        employee.get().setUniversity(employeeForm.getUniversity());
        employee.get().setVehicleName(employeeForm.getVehicleName());
        employee.get().setVehicleNo(employeeForm.getVehicleNo());
        Optional<Department> department = departmentRepository.findById(employeeForm.getDepartmentId());
        Optional<Position> position = positionRepository.findById(employeeForm.getPositionId());
        if (!department.isEmpty()) {
            employee.get().setDepartment(department.get());
        }
        if (!position.isEmpty()) {
            employee.get().setPosition(position.get());
        }
        employeeRepository.save(employee.get());
        return new Response("Employee is updated successfully", true);
    }

    @Override
    public List<Employee> findEmpByLevel() {
       List<Employee> employees = employeeRepository.findAll();
       return employees;
    }
}
