package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

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
    public void shouldAddAmountToBalanceHigher0() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldTestPay() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldAddAmountToBalanceLower0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(1000);
        account.add(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

     @Test
    public void shouldThrowExceptionAboutNegativeInitialBalance() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.add(3_000);
        });
    }

    @Test
    public void shouldThrowExceptionAboutNegativeCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                -5_000,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.add(3_000);
        });
    }

    @Test
    public void shouldReturnFalseBecausePayOverLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldReduceBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.add(2000);
        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldTestRate(){
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(2000);

        Assertions.assertEquals(-300, account.yearChange());
    }

    @Test
    public void shouldReturn0BecausePositiveBalance(){
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.add(2000);

        Assertions.assertEquals(0, account.yearChange());
    }

}
