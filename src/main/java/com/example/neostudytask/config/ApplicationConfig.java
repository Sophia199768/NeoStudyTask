package com.example.neostudytask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    @Bean
    public MonthMapper getMonthMapper() {
        return new MonthMapper();
    }

    @Bean
    public List<Calendar> getHolidays() {
        List<Calendar> holidays = new LinkedList<>();

        holidays.add(createCalendar(8, Calendar.MARCH));
        holidays.add(createCalendar(23, Calendar.FEBRUARY));
        holidays.add(createCalendar(9, Calendar.MAY));
        holidays.add(createCalendar(1, Calendar.MAY));
        holidays.add(createCalendar(4, Calendar.NOVEMBER));
        holidays.add(createCalendar(31, Calendar.DECEMBER));
        holidays.add(createCalendar(1, Calendar.JANUARY));
        holidays.add(createCalendar(2, Calendar.JANUARY));
        holidays.add(createCalendar(3, Calendar.JANUARY));
        holidays.add(createCalendar(4, Calendar.JANUARY));
        holidays.add(createCalendar(5, Calendar.JANUARY));
        holidays.add(createCalendar(6, Calendar.JANUARY));
        holidays.add(createCalendar(7, Calendar.JANUARY));
        return holidays;
    }

    private Calendar createCalendar(int dayOfMonth, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        return calendar;
    }
}
