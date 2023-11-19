package task1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AgeValidatorTest {

    @Test(description = "Verify that a user older than 18 is considered an adult")
    public void userOlderThanEighteenTest() {
        LocalDate birthDate = LocalDate.now().minusYears(26);
        boolean result = AgeValidator.isUserAdult(birthDate);
        Assert.assertTrue(result, "The user should be considered an adult");
    }

    @Test(description = "Verify that a user younger than 18 is not considered an adult")
    public void userYoungerThanEighteenTest() {
        LocalDate birthDate = LocalDate.now().minusYears(15);
        boolean result = AgeValidator.isUserAdult(birthDate);
        Assert.assertFalse(result, "The user should not be considered an adult");
    }

    @Test(description = "Verify that a user born exactly 18 years ago is considered an adult")
    public void userExactlyEighteenYearsOldTest() {
        LocalDate birthDate = LocalDate.now().minusYears(18);
        boolean result = AgeValidator.isUserAdult(birthDate);
        Assert.assertTrue(result, "The user should be considered an adult");
    }

    @Test(description = "Verify that a user born exactly one day less than 18 years ago is not considered an adult")
    public void userOneDayLessThanEighteenYearsOldTest() {
        LocalDate birthDate = LocalDate.now().minusYears(18).minusDays(1);
        boolean result = AgeValidator.isUserAdult(birthDate);
        Assert.assertTrue(result, "The user should not be considered an adult");
    }

    @Test(description = "Verify that a user born exactly one day more than 18 years ago is considered an adult")
    public void userOneDayMoreThanEighteenYearsOldTest() {
        LocalDate birthDate = LocalDate.now().minusYears(18).plusDays(1);
        boolean result = AgeValidator.isUserAdult(birthDate);
        Assert.assertFalse(result, "The user should be considered an adult");
    }
}
