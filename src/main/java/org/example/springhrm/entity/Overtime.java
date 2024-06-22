package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Overtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long overtimeId;
    private Date date;
    private Integer hours;
    private String reason;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
