package com.example.demo.repository;

import com.example.demo.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    @Query("SELECT d FROM Discount d " +
       "WHERE (LOWER(d.destination.name) LIKE LOWER(CONCAT('%', :destination, '%')) OR d.destination.name IS NULL) " +
       "OR (LOWER(d.destination.country) LIKE LOWER(CONCAT('%', :destination, '%')) OR d.destination.country IS NULL)")
    List<Discount> filterByDestination(String destination);
}
