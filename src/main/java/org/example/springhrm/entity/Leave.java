package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;
    private LocalDate date;
    private String type; // Example: Annual, Sick, Unpaid, etc.
    private String reason;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @Enumerated(EnumType.STRING)
    private  Status status; // Example: Draft, Approved,  Rejected
    @PrePersist
    protected  void onCreate() throws Exception {
     this.status = Status.DRAFT;
    }
}
