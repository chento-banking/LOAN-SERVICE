package com.chento.loan.repository;

import com.chento.loan.entity.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoanRepository extends MongoRepository<Loan, Long> {
    List<Loan> findByCustomerId(Long customerId);
}