package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class EmployeeBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeBenefitId;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "benefitId")
    private Benefit benefit;
}
