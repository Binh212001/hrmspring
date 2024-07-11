package org.example.springhrm.repo;

import org.example.springhrm.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product ", nativeQuery = true)
    Page<Product> findByPage(Pageable pageable);
}