package org.example;

public class DateCalculator {
    public String nextDate(int day, int month, int year) {
        // Check for valid inputs
        if(day <= 0 || day > 31 || month <= 0 || month > 12 || year < 1812 || year > 2212) {
            return "Invalid";
        }

        // Adjust for leap year
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int[] daysInMonth = {31, isLeapYear ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check if the day is valid for the given month
        if (day > daysInMonth[month - 1]) {
            return "Invalid";
        }

        // Increment the day
        day++;
        if (day > daysInMonth[month - 1]) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return String.format("%d-%d-%d", day, month, year);
    }
}