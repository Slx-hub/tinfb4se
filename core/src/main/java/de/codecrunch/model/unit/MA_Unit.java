package de.codecrunch.model.unit;

public abstract class MA_Unit {
    private int speed;
    private int maxLife;
    private int currentLife;

    public MA_Unit(int speed, int maxLife){
        this.speed = speed;
        this.maxLife = maxLife;
        this.currentLife = maxLife;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        if (!(speed < 0)){
            this.speed = speed;
        }
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public void setMaxLife(int maxLife) {
        if (!(maxLife <= 0)) {
            this.maxLife = maxLife;
        }
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        if(this.maxLife < currentLife){
            this.currentLife = maxLife;
        }else{
            this.currentLife = currentLife;
        }
    }

    public void takeDamage(int damage){
        if(this.currentLife < damage){
            this.currentLife = 0;
        }else{
            this.currentLife = this.currentLife - damage;
        }
    }

    public void heal(int healing){
        if (currentLife==0){
            this.currentLife = 0;
        } else if (this.maxLife < (this.currentLife+healing)){
            this.currentLife = this.maxLife;
        } else {
            this.currentLife += healing;
        }
    }
}
