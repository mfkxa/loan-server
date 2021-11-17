package com.example.loan.service;

import com.example.loan.bo.Gender;
import com.example.loan.bo.UserLoanPolicyMaterial;
import com.example.loan.dao.UserLoanPolicyMaterialDAO;
import org.springframework.stereotype.Service;

@Service
public class LoanPolicyService {
    private final UserLoanPolicyMaterialDAO userLoanPolicyMaterialDAO;

    public LoanPolicyService(UserLoanPolicyMaterialDAO userLoanPolicyMaterialDAO) {
        this.userLoanPolicyMaterialDAO = userLoanPolicyMaterialDAO;
    }

    public UserLoanPolicyMaterial getUserLoadPlanMaterial(String idCard) {
        return userLoanPolicyMaterialDAO.selectUserLoanPlanMaterial(idCard);
    }

    public String checkUserLoadPlan(String idCard, Integer loanTerm) {
        UserLoanPolicyMaterial userLoanPolicyMaterial = userLoanPolicyMaterialDAO.selectUserLoanPlanMaterial(idCard);
        Gender gender = userLoanPolicyMaterial.getGender();
        Integer lenderAge = userLoanPolicyMaterial.getLenderAge();
        String result = checkLoanUtil.checkeLenderAndLoanTerm(gender, lenderAge, loanTerm, userLoanPolicyMaterial.getHouseMaterial().getAge()).toString();
        return result;
    }

}
