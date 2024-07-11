package org.example.springhrm.repo;

import org.example.springhrm.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    @Query("SELECT e FROM Employee e")
    Page<Employee> findAndPagination(Pageable pageable);
    @Query("SELECT e FROM Employee e WHERE e.fullName LIKE %:keyword%")
    Page<Employee> findAndPaginationAndSearch(Pageable pageable, String keyword);
}