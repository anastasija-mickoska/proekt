package com.example.demo.repository;

import com.example.demo.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    // Custom query methods can be defined here, if needed
}
