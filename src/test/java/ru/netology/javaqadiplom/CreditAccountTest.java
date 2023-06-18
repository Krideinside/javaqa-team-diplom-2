package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    ///////////////////////////////МЕТОД ADD//////////////////////////////////////

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldReturnFalseIfNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.add(-3_000));
    }

    @Test
    public void shouldAddToBalanceHigher0() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldAddToBalanceLower0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(1000);
        account.add(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    //////////////////////////////////////МЕТОД PAY/////////////////////////////////////

    @Test
    public void shouldPayWithBalance0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(1_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldPayWithBalanceHigher0() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(2_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldPayWithBalanceLower0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(1_000);
        account.pay(2_000);

        Assertions.assertEquals(-3_000, account.getBalance());
    }

    @Test
    public void shouldReturnFalseIfPayWithNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.pay(-1_000));
    }

    @Test
    public void shouldReturnFalseIfPay0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.pay(0));
    }

    @Test
    public void shouldReturnFalseAndNotTouchingBalanceIfPayHigherThenCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.pay(6_000));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayToEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(5_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    //////////////////////////////INITIAL EXCEPTIONS////////////////////////////////////////

    @Test
    public void shouldThrowExceptionAboutNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1_000,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldThrowExceptionAboutNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void shouldThrowExceptionAboutNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    -15
            );
        });
    }

    //////////////////////////////////////////МЕТОД YEARCHANGE//////////////////////////////////////

    @Test
    public void shouldCalcYearChange() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(2000);

        Assertions.assertEquals(-300, account.yearChange());
    }

    @Test
    public void shouldCalcYearChangeWhenBalanceLower100() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(80);

        Assertions.assertEquals(-12, account.yearChange());
    }

    @Test
    public void shouldReturn0BecausePositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }


    //////////////////////////////////////ACCOUNT RATE////////////////////////////////////

    @Test
    public void shouldGetRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(1_000);

        Assertions.assertEquals(15, account.getRate());
    }

    @Test
    public void shouldSetRate() {
        CreditAccount account = new CreditAccount(
                0,
                5,
                15
        );
        account.pay(1_000);
        account.setRate(5);

        Assertions.assertEquals(5, account.getRate());
    }

    @Test
    public void shouldReturnFalseIfSetNegativeRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(1_000);
        account.setRate(-5);

        Assertions.assertEquals(15, account.getRate());
    }
}
