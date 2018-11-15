package de.codecrunch.controller;

import de.codecrunch.controller.item.CA_Item;
import de.codecrunch.controller.turret.CA_Turret;
import de.codecrunch.controller.ca_unit.CA_Unit;
import de.codecrunch.model.M_Game;

public class C_Game {
    private M_Game game = new M_Game();
    private C_Base base =  new C_Base();
    private C_Player player = new C_Player();
    private C_Computer computer = new C_Computer();
    private CA_Turret turret = new CA_Turret() {
    };
    private CA_Unit unit = new CA_Unit() {
    };
    private CA_Item item = new CA_Item() {
    };
}
