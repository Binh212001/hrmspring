package org.example.springhrm.repo;

import org.example.springhrm.entity.Employee;
import org.example.springhrm.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    List<Leave> findByDateAndEmployee(LocalDate date, Employee employee);
}