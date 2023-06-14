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
    public void shouldNotPayOverLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-6_000, account.getBalance());
    }

    @Test
    public void shouldReduceBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionAboutNegativeRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                -15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
}
