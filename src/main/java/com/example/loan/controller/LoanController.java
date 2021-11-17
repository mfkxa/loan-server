package com.example.loan.controller;

import com.example.loan.bo.UserLoanPolicyMaterial;
import com.example.loan.service.LoanPolicyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loan-plans")
public class LoanController {
    private final LoanPolicyService loanPolicyService;

    public LoanController(LoanPolicyService loanPolicyService) {
        this.loanPolicyService = loanPolicyService;
    }

    @GetMapping("/{idCard}")
    public UserLoanPolicyMaterial getUserLoadPlanMaterial(@PathVariable String idCard) {
        return loanPolicyService.getUserLoadPlanMaterial(idCard);
    }
    @GetMapping("/check/{idCard}/{loanTerm}")
    public String checkUserLoadPlan(@PathVariable String idCard,@PathVariable Integer loanTerm) {
        return loanPolicyService.checkUserLoadPlan(idCard,loanTerm);
    }

}
