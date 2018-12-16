package de.codecrunch.model.unit;

public class M_HealUnit extends MA_Unit {

    public M_HealUnit(){
        super(2,300);
    }

    // this Unit should drop a Heal fountain when killed... no idea how to implement that yet... maybe by just replacing it?
    private void dropHealFountain(){
        M_HealFountain healFountain = new M_HealFountain();
    }
}