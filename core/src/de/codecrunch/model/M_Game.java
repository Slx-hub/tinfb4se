package de.codecrunch.model;

import de.codecrunch.model.ma_item.MA_Item;
import de.codecrunch.model.ma_turret.MA_Turret;
import de.codecrunch.model.ma_unit.MA_Unit;

public class M_Game {
    private M_Map m_map = new M_Map();
    private M_Tile m_tile = new M_Tile();
    private M_Base m_base = new M_Base();
    private M_User m_user = new M_User();
    private MA_Item ma_item = new MA_Item() {
    };
    private MA_Unit ma_unit = new MA_Unit() {
    };
    private MA_Turret ma_turret = new MA_Turret() {
    };
}
