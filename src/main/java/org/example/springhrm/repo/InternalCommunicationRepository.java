package org.example.springhrm.repo;

import org.example.springhrm.entity.InternalCommunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalCommunicationRepository extends JpaRepository<InternalCommunication, Long> {
}