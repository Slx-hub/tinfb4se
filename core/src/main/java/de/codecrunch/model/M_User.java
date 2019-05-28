package de.codecrunch.model;

public class M_User {
    private int money = 0;

    public int getBalance() {
        return money;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void drawMoney(int amount) {
        money -= amount;
    }
}
