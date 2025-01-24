package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.model.Discount;
import com.example.demo.repository.DiscountRepository;
import java.util.List;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }
}
