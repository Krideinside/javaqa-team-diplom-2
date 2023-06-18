package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void shouldTransfer() {
        Bank bank = new Bank();
        CreditAccount accountFrom = new CreditAccount(
                0,
                5_000,
                15
        );

        SavingAccount accountTo = new SavingAccount(
                1_000,
                1_000,
                10_000,
                15
        );

        bank.transfer(accountFrom, accountTo, 5_000);

        Assertions.assertEquals(-5_000, accountFrom.getBalance());
        Assertions.assertEquals(6_000, accountTo.getBalance());
    }

//    @Test
//    public void shouldThrowExceptionAboutNegativeBalanceFrom() {
//        Bank bank = new Bank();
//        Account from = new Account();
//        Account to = new Account();
//
//        from.pay(9_000);
//        to.add(1_000);
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//        bank.transfer(from, to, 5_000);
//    });
//    }
}
