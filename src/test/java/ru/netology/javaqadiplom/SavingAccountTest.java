package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void ShouldNotPayWhenAmountOfPayIs0() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                2
        );
        Assertions.assertEquals(false, account.pay(0));
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void shouldCalcPercents() {

        SavingAccount account = new SavingAccount(
                89,
                0,
                10_000,
                5
        );
        Assertions.assertEquals(4, account.yearChange());
    }

    @Test
    public void shouldGetMinBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(1_000, account.getMinBalance());
    }

    @Test
    public void shouldGetMaxBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    @Test
    public void shouldSetMinBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.setMinBalance(0);
        Assertions.assertEquals(0, account.getMinBalance());
        account.setMinBalance(1_999);
        Assertions.assertEquals(1_999, account.getMinBalance());
    }

    @Test
    public void shouldNotSetMinBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMinBalance(-1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMinBalance(10000);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMinBalance(2_001);
        });
    }

    @Test
    public void shouldSetMaxBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.setMaxBalance(2_000);
        Assertions.assertEquals(2_000, account.getMaxBalance());
        account.setMaxBalance(3_000);
        Assertions.assertEquals(3_000, account.getMaxBalance());
        account.setMaxBalance(10_999);
        Assertions.assertEquals(10_999, account.getMaxBalance());
    }

    @Test
    public void shouldNotSetMaxBalance() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMaxBalance(-1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMaxBalance(999);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setMaxBalance(1_999);
        });
    }

    @Test
    public void shouldSetRate() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.setRate(13);
        Assertions.assertEquals(13, account.getRate());
        account.setRate(3_000);
        Assertions.assertEquals(3_000, account.getRate());
    }
    
    @Test
    public void shouldNotSetRate() {

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.setRate(-1);
        });
    }

}
