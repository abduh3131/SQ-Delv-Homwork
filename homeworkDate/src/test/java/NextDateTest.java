import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.DateCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NextDateTest {

    private DateCalculator dateCalculator;

    @BeforeEach
    void setUp() {
        dateCalculator = new DateCalculator();
    }

    @Test
    void testNextDate_EndOfMonth_NonLeapYear() {
        assertEquals("1-3-2021", dateCalculator.nextDate(28, 2, 2021),
                "Testing next day for the end of February in a non-leap year");
    }

    @Test
    void testNextDate_EndOfMonth_LeapYear() {
        assertEquals("29-2-2020", dateCalculator.nextDate(28, 2, 2020),
                "Testing next day for February 28 in a leap year");
    }

    @Test
    void testNextDate_EndOfYear() {
        assertEquals("1-1-2022", dateCalculator.nextDate(31, 12, 2021),
                "Testing next day for the end of the year");
    }

    @Test
    void testNextDate_MidMonth() {
        assertEquals("16-7-2021", dateCalculator.nextDate(15, 7, 2021),
                "Testing a regular day in the middle of a month");
    }

    @Test
    void testNextDate_FebruaryNonLeapYear() {
        assertEquals("Invalid", dateCalculator.nextDate(29, 2, 1900),
                "Testing invalid date for February 29 in a non-leap year");
    }

    @Test
    void testNextDate_InvalidDay() {
        assertEquals("Invalid", dateCalculator.nextDate(32, 1, 2020),
                "Testing invalid day");
    }

    @Test
    void testNextDate_InvalidAprilEnd() {
        assertEquals("Invalid", dateCalculator.nextDate(31, 4, 2021),
                "Testing invalid April end");
    }

    @Test
    void testNextDate_InvalidMonth() {
        assertEquals("Invalid", dateCalculator.nextDate(1, 13, 2021),
                "Testing invalid month");
    }

    @Test
    void testNextDate_NormalDay() {
        assertEquals("16-1-1812", dateCalculator.nextDate(15, 1, 1812),
                "Testing normal day");
    }

    @Test
    void testNextDate_YearBoundary() {
        assertEquals("1-1-2213", dateCalculator.nextDate(31, 12, 2212),
                "Testing year boundary");
    }

    // Add more tests if required for other edge cases or input validations
}


