package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

//    public boolean pay(int amount) {
//        if (amount <= 0) {
//            return false;
//        } else {
//            balance = balance - amount;
//            return true;
//        }
//    }
//
//    public boolean add(int amount) {
//        if (amount <= 0) {
//            return false;
//        } else {
//            balance = balance + amount;
//            return true;
//        }
//    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
