package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void shouldReduceFrom() {
        Bank bank = new Bank();
        Account from = new Account();
        from.balance = 5_000;
        Account to = new Account();
        to.balance = 0;

        bank.transfer(from, to, 1_000);

        Assertions.assertEquals(4_000, from.getBalance());
    }

    @Test
    public void shouldIncreseTo() {
        Bank bank = new Bank();
        Account from = new Account();
        from.balance = 5_000;
        Account to = new Account();
        to.balance = 0;

        bank.transfer(from, to, 1_000);

        Assertions.assertEquals(1_000, to.getBalance());
    }

    @Test
    public void shouldReturnFalseIfNegativeAmount() {
        Bank bank = new Bank();
        Account from = new Account();
        from.balance = 5_000;
        Account to = new Account();
        to.balance = 0;

        Assertions.assertEquals(false, bank.transfer(from, to, -1_000));
    }

    @Test
    public void shouldReturnFalseIfBalanceLowerAmount() {
        Bank bank = new Bank();
        Account from = new Account();
        from.balance = 1_000;
        Account to = new Account();
        to.balance = 0;

        Assertions.assertEquals(false, bank.transfer(from, to, 2_000));
    }

    @Test
    public void shouldTransferToNegativeBalance() {
        Bank bank = new Bank();
        Account from = new Account();
        from.balance = 5_000;
        Account to = new Account();
        to.balance = -1_000;

        bank.transfer(from, to, 2_000);

        Assertions.assertEquals(1_000, to.getBalance());
    }
}
