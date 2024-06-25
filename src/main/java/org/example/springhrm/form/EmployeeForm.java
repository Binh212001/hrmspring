package org.example.springhrm.form;

import lombok.Value;
import org.example.springhrm.entity.Contract;
import org.example.springhrm.entity.Department;
import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Position;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Employee}
 */
@Value
public class EmployeeForm implements Serializable {
    private String address;
    private Date dateOfBirth;
    private long departmentId;
    private String email;
    private String firstName;
    private String gender;
    private double gpa;
    private String graduation;
    private Date hireDate;
    private Long id;
    private String lastName;
    private String password;
    private String phone;
    private long positionId;
    private String university;
    private String vehicleName;
    private String vehicleNo;

    public Employee mapToEty(){
        Employee employee = new Employee();
        employee.setAddress(address);
        employee.setDateOfBirth(this.dateOfBirth);
        employee.setEmail(email);
        employee.setFirstName(firstName);
        employee.setGender(gender);
        employee.setGpa(gpa);
        employee.setGraduation(graduation);
        employee.setHireDate(this.getHireDate());
        employee.setLastName(lastName);
        employee.setPassword(password);
        employee.setPhone(phone);
        employee.setUniversity(university);
        employee.setVehicleName(vehicleName);
        employee.setVehicleNo(vehicleNo);
        return employee;
    }
}