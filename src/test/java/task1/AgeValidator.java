package task1;

import utils.DateUtils;

import java.time.LocalDate;

public class AgeValidator {
    public static boolean isUserAdult(LocalDate birthDate) {
        int age = DateUtils.calculateAge(birthDate);
        return age >= 18;
    }
}
