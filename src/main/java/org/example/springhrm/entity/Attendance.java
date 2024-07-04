package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    private Integer month;
    private Integer year;
    @Enumerated(EnumType.STRING)
    private Status status;
    private  Date createdAt;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToMany
    private List<AttendanceItem> attendanceItems;
}
