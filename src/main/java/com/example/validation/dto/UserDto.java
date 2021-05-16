package com.example.validation.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class UserDto {

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.")
    private String phoneNumber;

    @Size(min=6, max=6)
    private String reqYearMonth;    // yyyymm

    @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다.")
    public boolean isreqYearMonthValidation(){
//        this.reqYearMonth = getReqYearMonth() + "01";
        try {
            LocalDate localDate = LocalDate.parse(getReqYearMonth()+ "01", DateTimeFormatter.ofPattern("yyyyMMdds"));

        }catch (Exception e){
            return false;
        }

        return true;
    }
}
