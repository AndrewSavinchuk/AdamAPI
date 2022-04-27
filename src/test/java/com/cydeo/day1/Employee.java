package com.cydeo.day1;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String name;
    private Integer age;
}
