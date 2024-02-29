package org.example;

import java.util.*;

public class NextDate {
    public static String calculate(int day, int month, int year) {
        // Check for valid year
        if (year < 1812 || year > 2212) {
            return "Invalid";
        }

        // Check for valid month
        if (month < 1 || month > 12) {
            return "Invalid";
        }

        // Check for valid day
        if (day < 1 || day > 31) {
            return "Invalid";
        }

        // Handling February and leap years
        if (month == 2) {
            if (isLeapYear(year)) {
                if (day > 29) return "Invalid";
            } else {
                if (day > 28) return "Invalid";
            }
        }

        // Handling months with 30 days
        if (Arrays.asList(4, 6, 9, 11).contains(month) && day > 30) {
            return "Invalid";
        }

        // Increment the day
        day++;
        if (day > 31) {
            day = 1;
            month++;
        }

        if (month == 2 && day > (isLeapYear(year) ? 29 : 28)) {
            day = 1;
            month++;
        }

        if (Arrays.asList(4, 6, 9, 11).contains(month) && day > 30) {
            day = 1;
            month++;
        }

        if (month > 12) {
            month = 1;
            year++;
        }

        return String.format("%d-%d-%d", day, month, year);
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static void main(String[] args) {
        // The main method can be used to run some basic tests or examples
        System.out.println(calculate(28, 2, 2021)); // Outputs "1-3-2021"
        System.out.println(calculate(29, 2, 2020)); // Outputs "1-3-2020" (Leap year)
        // Additional tests can be added here
    }
}
