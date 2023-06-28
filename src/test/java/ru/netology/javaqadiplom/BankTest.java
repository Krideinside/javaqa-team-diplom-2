package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void shouldTransferFromCreditToSaving() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                1_000,
                1_000,
                15_000,
                5
        );

        acc1.add(7_000);

        Bank bank = new Bank();
        Assertions.assertEquals(true, bank.transfer(acc1,acc2,4_000));
        Assertions.assertEquals(3_000,acc1.getBalance());
        Assertions.assertEquals(5_000,acc2.getBalance());
    }

    @Test
    public void shouldTransferFromSavingToCredit() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                2_000,
                1_000,
                15_000,
                5
        );

        acc1.add(7_000);

        Bank bank = new Bank();
        Assertions.assertEquals(true, bank.transfer(acc2,acc1,1_000));
        Assertions.assertEquals(8_000,acc1.getBalance());
        Assertions.assertEquals(1_000,acc2.getBalance());
    }

    @Test
    public void shouldNotTransferFromCreditToSavingWhenAmount0() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                1_000,
                1_000,
                15_000,
                5
        );

        acc1.add(7_000);

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc1, acc2, 0));
        Assertions.assertEquals(7_000, acc1.getBalance());
        Assertions.assertEquals(1_000, acc2.getBalance());
    }

    @Test
    public void shouldNotTransferFromCreditToSavingWhenAmountLowerThan0() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                1_000,
                1_000,
                15_000,
                5
        );

        acc1.add(7_000);

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc1, acc2, -1_000));
        Assertions.assertEquals(7_000, acc1.getBalance());
        Assertions.assertEquals(1_000, acc2.getBalance());
    }

    @Test
    public void shouldNotTransferFromCreditToSavingWhenAmountIsHigherThanBalance() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                1_000,
                1_000,
                15_000,
                5
        );

        acc1.add(7_000);

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc1, acc2, 8_000));
        Assertions.assertEquals(7_000, acc1.getBalance());
        Assertions.assertEquals(1_000, acc2.getBalance());
    }

    @Test
    public void shouldNotTransferFromSavingToCreditWhenAmountIsHigherThanMinBalance() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                1_000,
                1_000,
                15_000,
                5
        );

        acc1.add(7_000);

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc2, acc1, 1_000));
        Assertions.assertEquals(7_000, acc1.getBalance());
        Assertions.assertEquals(1_000, acc2.getBalance());
    }

    @Test
    public void shouldNotTransferFromSavingToCreditWhenAmount0() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                1_000,
                1_000,
                15_000,
                5
        );

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc2, acc1, 0));
        Assertions.assertEquals(0, acc1.getBalance());
        Assertions.assertEquals(1_000, acc2.getBalance());
    }

    @Test
    public void shouldNotTransferFromSavingToCreditWhenAmountIsHigherThanBalance() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                3_000,
                0,
                15_000,
                5
        );

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc2, acc1, 4_000));
        Assertions.assertEquals(0, acc1.getBalance());
        Assertions.assertEquals(3_000, acc2.getBalance());
    }
    @Test
    public void shouldNotTransferFromSavingToCreditWhenAmountIsLowerThan0() {
        CreditAccount acc1 = new CreditAccount(
                0,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                3_000,
                0,
                15_000,
                5
        );

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc2, acc1, -1_000));
        Assertions.assertEquals(0, acc1.getBalance());
        Assertions.assertEquals(3_000, acc2.getBalance());
    }

    @Test
    public void shouldNotTransferFromCreditToSavingWhenBalanceOfSavingWillBeHigherThanMaxBalance() {
        CreditAccount acc1 = new CreditAccount(
                9_000,
                10_000,
                15
        );
        SavingAccount acc2 = new SavingAccount(
                3_000,
                0,
                5_000,
                5
        );

        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(acc1, acc2, 3_000));
        Assertions.assertEquals(9_000, acc1.getBalance());
        Assertions.assertEquals(3_000, acc2.getBalance());
    }

}
