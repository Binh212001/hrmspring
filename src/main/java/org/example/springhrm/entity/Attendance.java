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
    private String status;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToMany
    private List<AttendanceItem> attendanceItems;
}
