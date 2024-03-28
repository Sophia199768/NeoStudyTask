package com.example.neostudytask.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class RequestCalculate {
    private Double averageSalary;
    private Integer amountOfHolidays;
    private Integer startDay;
    private Integer startMonth;
    private Integer year;
}
