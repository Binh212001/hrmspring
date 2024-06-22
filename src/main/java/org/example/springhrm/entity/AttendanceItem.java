package org.example.springhrm.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table
public class AttendanceItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceItemId;
    private Date date;
    private Date checkInTime;
    private Date checkOutTime;
    private Integer workingHours;
    private Integer overtimeHours;
}
