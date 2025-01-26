package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.model.Discount;
import com.example.demo.repository.DiscountRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<com.example.demo.soap.models.Discount> getAllDiscounts() {
        List<com.example.demo.model.Discount> discounts = discountRepository.findAll();
        return discounts.stream()
                .map(this::convertToSoapModel)
                .toList();
    }

    private com.example.demo.soap.models.Discount convertToSoapModel(com.example.demo.model.Discount discount) {
        com.example.demo.soap.models.Discount soapDiscount = new com.example.demo.soap.models.Discount();
        soapDiscount.setId(discount.getId());
        soapDiscount.setDescription(discount.getDescription());
        soapDiscount.setDiscountValue(discount.getDiscountValue());
        soapDiscount.setStartDate(discount.getStartDate());
        soapDiscount.setEndDate(discount.getEndDate());
        return soapDiscount;
    }

    public List<com.example.demo.soap.models.Discount> getSortedDiscounts() {
        List<com.example.demo.soap.models.Discount> discounts = getAllDiscounts(); 
        discounts.sort((d1, d2) -> Double.compare(d2.getDiscountValue(), d1.getDiscountValue()));
        return discounts;
    }

    public List<Discount> filterDiscountsByDestination(String destination) {
        return discountRepository.filterByDestination(destination);
    }

    public Discount updateDiscount(Integer id, Discount updatedDiscount) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Discount not found with ID: " + id));
        if (updatedDiscount.getDescription() != null) {
            discount.setDescription(updatedDiscount.getDescription());
        }
        if (updatedDiscount.getDiscountValue() != 0) {
            discount.setDiscountValue(updatedDiscount.getDiscountValue());
        }
        if (updatedDiscount.getDiscountType() != null) {
            discount.setDiscountType(updatedDiscount.getDiscountType());
        }
        if (updatedDiscount.getPrice() != 0) {
            discount.setPrice(updatedDiscount.getPrice());
        }
        if (updatedDiscount.getStartDate() != null) {
            discount.setStartDate(updatedDiscount.getStartDate());
        }
        if (updatedDiscount.getEndDate() != null) {
            discount.setEndDate(updatedDiscount.getEndDate());
        }
        if (updatedDiscount.getStatus() != null) {
            discount.setStatus(updatedDiscount.getStatus());
        }
        if (updatedDiscount.getDestination() != null) {
            discount.setDestination(updatedDiscount.getDestination());
        }

        return discountRepository.save(discount);
    }
}
