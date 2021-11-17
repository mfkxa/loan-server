package com.example.loan.service;

import com.example.loan.bo.CheckResultBo;
import com.example.loan.bo.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Parameterized.class)
public class checkLoanUtilTest {

    private Gender gender;
    private Integer lenderAge;
    private Integer loanTerm;
    private Integer houseAge;
    private boolean result;
    private String message;

    public checkLoanUtilTest(Gender gender, Integer lenderAge, Integer loanTerm, Integer houseAge, boolean result, String message) {
        this.gender = gender;
        this.lenderAge = lenderAge;
        this.result = result;
        this.loanTerm = loanTerm;
        this.houseAge = houseAge;
        this.message = message;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Gender.MALE,35,30,0,true,""},
                {Gender.MALE,36,30,0,false,"男性_年龄_加_贷款年限_不能超过65"},
                {Gender.FEMALE,35,26,0,false,"女性_年龄_加_贷款年限_不能超过60"},
                {Gender.FEMALE,25,0,0,true,""},
                {Gender.MALE,30,31,0,false,"住房贷款年限最长为30年"},
                {Gender.MALE,30,30,11,false,"贷款年限加上房龄总和不能超过40年"},
                {Gender.MALE,30,30,10,true,""},
     });
    }
    @Test
    public void checkParams() {
        check(gender, lenderAge, loanTerm, houseAge,result, message);
    }

    private void check(Gender gender, Integer lenderAge, Integer loanTerm, Integer houseAge,boolean result,String message) {
        CheckResultBo bo = checkLoanUtil.checkeLenderAndLoanTerm(gender, lenderAge, loanTerm,houseAge);
        assertThat(bo.getReturnCode()).isEqualTo(result);
        assertThat(bo.getReturnMessage()).isEqualTo(message);
    }
}