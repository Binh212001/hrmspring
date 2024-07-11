package org.example.springhrm.repo;

import org.example.springhrm.entity.Attendance;
import org.example.springhrm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployeeAndMonthAndYear(Optional<Employee> employee, Integer month, Integer year);

    List<Attendance> findByEmployee(Employee employee);
}