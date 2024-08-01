package com.udemy.spring.spring_selenium.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class CommonUtil {
    /**
     * This method generates a random date within the current year, ensuring it meets the specified criteria
     * The date is formatted as “DD MMM YYYY”:
     * @return
     */
    public static String getRandomDateInCurrentYear() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int daysInYear = LocalDate.of(currentYear, 12, 31).getDayOfYear();
        int randomDayOfYear = ThreadLocalRandom.current().nextInt(currentDate.getDayOfYear(), daysInYear + 1);
        LocalDate randomDate = LocalDate.ofYearDay(currentYear, randomDayOfYear);

        // Format the date as "DD MMM YYYY"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return randomDate.format(formatter);
    }

    /**
     * This method generates a random date within the next two months, ensuring it meets the specified criteria.
     * The date is formatted as “DD MMM YYYY”:
     * @return
     */
    public static String getRandomDateWithinNextTwoMonths() {
        LocalDate currentDate = LocalDate.now();
        LocalDate twoMonthsFromNow = currentDate.plus(2, ChronoUnit.MONTHS);

        long daysBetween = ChronoUnit.DAYS.between(currentDate, twoMonthsFromNow);
        long randomDays = ThreadLocalRandom.current().nextLong(daysBetween + 1);

        LocalDate randomDate = currentDate.plus(randomDays, ChronoUnit.DAYS);

        // Format the date as "DD MMM YYYY"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return randomDate.format(formatter);
    }
}