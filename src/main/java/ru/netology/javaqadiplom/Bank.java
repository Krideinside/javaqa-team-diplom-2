package ru.netology.javaqadiplom;

import javax.swing.colorchooser.AbstractColorChooserPanel;

public class Bank extends Account {

    /**
     * Операция перевода указанной суммы с одного счёта на другой.
     * Если операция прошла успешно, то баланс счёта from должен
     * уменьшиться на эту сумму, а баланс счёта to увеличиться.
     * Если операция прошла неуспешно, балансы обоих счетов никак
     * измениться не должны.
     *
     * @param from   - счёт с которого переводим
     * @param to     - счёт на который переводим
     * @param amount - сумма перевода
     * @return - true если операция прошла успешно, false иначе
     */
    public boolean transfer(Account from, Account to, int amount) {
        if (amount <= 0) {
            return false;
        }
        if (from.balance < amount) {
            return false;
        }
        if (to.add(amount)) {
            if (from.pay(amount)) {
                return true;
            } else {
                to.pay(amount);
            }
        }
        return false;
    }
}
