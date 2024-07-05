package org.example.springhrm.repo;

import org.example.springhrm.entity.AttendanceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AttendanceItemRepository extends JpaRepository<AttendanceItem, Long> {
    AttendanceItem findByDateAndEmployeeId(LocalDate localDate, Long employeeId);
}