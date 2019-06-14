package de.codecrunch.model;

public class M_Base {

    private int maxLife;
    private int currentLife;

    public M_Base(){
        setMaxLife(20);
        setCurrentLife(this.maxLife);
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        if (this.maxLife >= currentLife)
            this.currentLife = currentLife;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        if (maxLife > 0)
            this.maxLife = maxLife;
    }

    public void takeDamage(){
        setCurrentLife(currentLife-1);
    }

}
