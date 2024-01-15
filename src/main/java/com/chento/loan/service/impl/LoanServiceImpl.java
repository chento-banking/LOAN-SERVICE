package com.chento.loan.service.impl;

import com.chento.loan.entity.Loan;
import com.chento.loan.repository.LoanRepository;
import com.chento.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }
    @Override
    public List<Loan> getList() {
        return loanRepository.findAll();
    }
    @Override
    public List<Loan> getByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

}