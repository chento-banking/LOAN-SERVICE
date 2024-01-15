package com.chento.loan.controller;

import com.chento.loan.dto.LoanDTO;
import com.chento.loan.entity.Loan;
import com.chento.loan.mapper.LoanMapper;
import com.chento.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/loans")
public class LoanController {


    private final LoanService loanService;
    private final LoanMapper loanMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LoanDTO dto){
        Loan loan = loanService.save(loanMapper.toLoan(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(loanService.getList());
    }

    @GetMapping("{customerId}")
    public ResponseEntity<?> getByCustomerId(
            @RequestHeader("chentobank-corelation-id") String correlationId,
            @PathVariable Long customerId){
        log.debug("correlation-idf found: {}",correlationId);
        System.out.println("================called loan service============");
        List<Loan> loans = loanService.getByCustomerId(customerId);

        return ResponseEntity.ok(loans);
    }
}