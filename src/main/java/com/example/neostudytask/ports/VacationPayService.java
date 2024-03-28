package com.example.neostudytask.ports;

import java.util.Calendar;
import java.util.Date;

public interface VacationPayService {
   Double calculate(Double averageSalary, Integer amountOfHolidays, Calendar startDateHoliday);
}
