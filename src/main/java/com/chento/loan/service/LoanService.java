package com.chento.loan.service;

import com.chento.loan.entity.Loan;

import java.util.List;

public interface LoanService {
    Loan save(Loan loan);

    List<Loan> getList();

    List<Loan> getByCustomerId(Long customerId);
}