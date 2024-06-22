package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;
    private Date payDate;
    private Double basicSalary;
    private Double bonuses;
    private Double deductions;
    private Double netSalary;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
