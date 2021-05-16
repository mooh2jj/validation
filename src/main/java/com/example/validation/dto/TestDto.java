package com.example.validation.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class TestDto {

    @NotEmpty
    @Size(min = 1, max = 10)
    private String name;

    @Min(1)
    private Integer age;
}
