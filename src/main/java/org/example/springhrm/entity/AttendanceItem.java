package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Entity
@Table
@Getter
@Setter
public class AttendanceItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceItemId;
    private LocalDate date;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private Float workingHours;
    private Float overtimeHours;
    private Long employeeId;
    private  String dayOfWeek;
}
