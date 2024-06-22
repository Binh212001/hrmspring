package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;
    private Date date;
    private String type; // Example: Annual, Sick, Unpaid, etc.
    private String status; // Example: Approved, Pending, Rejected
    private String reason;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
