package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String address;
    private Date hireDate;
    private String university;
    private String vehicleName;
    private String vehicleNo;
    private double gpa;
    private String graduation;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @OneToOne
    @JoinColumn(name = "contractId")
    private Contract contract;
    @PrePersist
    protected  void  create(){
        this.fullName = this.firstName + " " + this.lastName;
    }
}


