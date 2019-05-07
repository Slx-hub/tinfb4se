package de.codecrunch.model;

public class M_Base {

    private int maxLife;
    private int currentLife;

    public M_Base(){
        setMaxLife(100);
        setCurrentLife(this.maxLife);
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public void takeDamage(){
        setCurrentLife(currentLife-1);
    }

}
