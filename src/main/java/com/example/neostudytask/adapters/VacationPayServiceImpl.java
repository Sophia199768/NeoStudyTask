package com.example.neostudytask.adapters;

import com.example.neostudytask.ports.VacationPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationPayServiceImpl implements VacationPayService {
    private final List<Calendar> holidays;
    private final Double AVERAGE_DAYS = 29.3;

    public Double calculate(Double averageSalary, Integer amountOfHolidays, Calendar startDateHoliday) {
        amountOfHolidays = countWeekdays(amountOfHolidays, startDateHoliday);
        return (averageSalary * amountOfHolidays) / AVERAGE_DAYS;
    }

    private Boolean holidayMatch(Calendar day) {
        return holidays.stream().anyMatch(holiday -> day.get(Calendar.DAY_OF_MONTH) == holiday.get(Calendar.DAY_OF_MONTH)
                        && day.get(Calendar.MONTH) == holiday.get(Calendar.MONTH));
    }

    private Integer countWeekdays(Integer amountOfHolidays, Calendar start) {
        Integer weekends = 0;

        for (int i = 0; i < amountOfHolidays; i++) {
            if (Calendar.SATURDAY == start.get(Calendar.DAY_OF_WEEK)
                    || Calendar.SUNDAY == start.get(Calendar.DAY_OF_WEEK)
            || holidayMatch(start)) {
                weekends++;
            }
            start.roll(Calendar.DAY_OF_MONTH, 1);
        }

        return amountOfHolidays - weekends;
    }
}
