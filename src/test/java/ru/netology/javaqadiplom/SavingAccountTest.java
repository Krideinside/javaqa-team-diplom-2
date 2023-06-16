package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test   // works
    public void ShouldThrowExceptionWhenRateIsLowerThan0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -4
            );
        });
    }

    @Test   // doesn't work
    public void ShouldThrowExceptionWhenInitialIsLowerThanMin() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    2_000,
                    10_000,
                    2
            );
        });
    }

    @Test   // doesn't work
    public void ShouldThrowExceptionWhenMaxIsLowerThanMin() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    10_000,
                    3_000,
                    2
            );
        });
    }

    @Test   // doesn't work
    public void ShouldThrowExceptionWhenMinIsLowerThan0() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    -1_000,
                    15_000,
                    2
            );
        });
    }

    @Test   // works
    public void ShouldPayWhenAmountOfPayIsLowerThanBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                2
        );

        account.pay(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test   // works
    public void ShouldNotPayWhenAmountOfPayIs0() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                2
        );

        Assertions.assertEquals(false, account.pay(0));
    }

    @Test   // doesn't work
    public void ShouldNotPayWhenAmountOfPayIsHigherThanBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                2
        );

        account.pay(3000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test   // doesn't work
    public void ShouldNotPayWhenNewBalanceIsLowerThanMin() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                2
        );

        account.pay(1500);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test   // doesn't work
    public void shouldAddLessThanMaxBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test   // doesn't work
    public void shouldAddWhenBalanceEqualsToMax() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test   // works
    public void shouldNotAddWhenBalanceIsHigherThanMax() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test   // doesn't work
    public void shouldCalcPercents() {

        SavingAccount account = new SavingAccount(
                89,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(4, account.yearChange());

    }
}
