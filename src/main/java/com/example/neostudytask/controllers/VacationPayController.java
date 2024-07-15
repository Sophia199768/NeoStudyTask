package com.example.neostudytask.controllers;

import com.example.neostudytask.config.MonthMapper;
import com.example.neostudytask.model.RequestCalculate;
import com.example.neostudytask.model.ResponseCalculate;
import com.example.neostudytask.adapters.VacationPayServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequiredArgsConstructor
public class VacationPayController {
    private final VacationPayServiceImpl vacationPayService;
    private final MonthMapper monthMapper;

    @GetMapping("/calculate")
    public ResponseCalculate getCalculate(@RequestBody RequestCalculate request) {
        Calendar calendar = new GregorianCalendar(request.getYear(),  monthMapper.map(request.getStartMonth()), request.getStartDay());
        return new ResponseCalculate(vacationPayService.calculate(
                request.getAverageSalary(),
                request.getAmountOfHolidays(),
                calendar));
    }
}
