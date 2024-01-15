package com.chento.loan.controller;


import com.chento.loan.config.LoanServiceConfig;
import com.chento.loan.property.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/config")
public class ConfigController {

    private final LoanServiceConfig serviceConfig;

    @GetMapping("/properties")
    public ResponseEntity<?> getProperties()  {

        Properties properties = new Properties(
                serviceConfig.getMsg(),
                serviceConfig.getBuildVersion(),
                serviceConfig.getMailDetails(),
                serviceConfig.getActiveBranches()
        );

        return ResponseEntity.ok(properties);
    }

}
