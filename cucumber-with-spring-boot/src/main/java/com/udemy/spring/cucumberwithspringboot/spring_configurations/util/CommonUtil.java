package com.udemy.spring.cucumberwithspringboot.spring_configurations.util;

import java.io.File;
import java.nio.file.FileSystems;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class CommonUtil {
    /**
     * This method generates a random date within the current year, ensuring it meets the specified criteria
     * The date is formatted as “DD MMM YYYY”:
     *
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
     *
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

    /**
     * Purpose of this to delete all images taken by TakesScreenShot
     */
    public static void deleteAllImages() {
        // Specify the directory where the screenshots are saved
        String screenshotDir = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator() + "screenshots";

        // Create a File object for the directory
        File dir = new File(screenshotDir);

        // Get a list of all files in the directory
        File[] files = dir.listFiles((d, name) -> name.endsWith(".png") || name.endsWith(".jpg"));

        // Delete each file
        if (files != null) {
            for (File file : files) {
                if (file.delete()) {
                    System.out.println("Deleted " + file.getName());
                } else {
                    System.out.println("Failed to delete " + file.getName());
                }
            }
        } else {
            System.out.println("Directory not found or is empty.");
        }
    }
}