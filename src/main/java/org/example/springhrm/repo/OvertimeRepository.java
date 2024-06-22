package org.example.springhrm.repo;

import org.example.springhrm.entity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvertimeRepository extends JpaRepository<Overtime, Long> {
}