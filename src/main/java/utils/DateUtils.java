package utils;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {
    public static int calculateAge(LocalDate birthDate) {
        var currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
