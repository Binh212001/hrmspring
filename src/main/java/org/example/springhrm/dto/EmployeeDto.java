package org.example.springhrm.dto;

import lombok.Data;
import lombok.Value;
import org.example.springhrm.entity.Contract;
import org.example.springhrm.entity.Department;
import org.example.springhrm.entity.Position;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link org.example.springhrm.entity.Employee}
 */
@Value
public class EmployeeDto implements Serializable {
    Long employeeId;
    String email;
    String password;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String gender;
    String phone;
    String address;
    Date hireDate;
    Department department;
    Position position;
    Contract contract;
}