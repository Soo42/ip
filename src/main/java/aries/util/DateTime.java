package aries.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTime {
    private DateTime() {}

    private static final String[] DATE_TIME_PATTERN = new String[]{
            "yyyy-MM-dd HHmm", "yyyy-MM-dd", "dd-MM-yyyy HHmm", "dd-MM-yyyy",
            "dd/MM/yyyy HHmm", "dd/MM/yyyy", "yyyy/MM/dd HHmm", "yyyy/MM/dd", 
            "yyyy.MM.dd HHmm", "yyyy.MM.dd", "dd.MM.yyyy HHmm", "dd.MM.yyyy", 
            "dd MMM yyyy HHmm", "dd MMM yyyy", "yyyy MMM dd HHmm", "yyyy MMM dd"
            };

    public static LocalDateTime parse(String dateTimeStr) throws DateTimeParseException {
        for (String pattern : DATE_TIME_PATTERN) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                if (pattern.contains("HHmm")) {
                    return LocalDateTime.parse(dateTimeStr, formatter);
                } else {
                    LocalDate date = LocalDate.parse(dateTimeStr, formatter);
                    return date.atStartOfDay();
                }
            } catch (DateTimeParseException e) {}
        }
        
        throw new DateTimeParseException("Invalid date/time format: " + dateTimeStr, dateTimeStr, 0);
    }

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy, h:mma")).toUpperCase();
    }
}
