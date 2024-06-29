package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
public class Overtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long overtimeId;
    private Date date;
    private Float duration;
    private String reason;
    private Time startTime;
    private Time endTime;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
