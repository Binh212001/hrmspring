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
    private String status;
    private  Date createdAt;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToMany
    private List<AttendanceItem> attendanceItems;
}
