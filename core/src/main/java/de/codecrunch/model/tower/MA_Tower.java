package de.codecrunch.model.tower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import de.codecrunch.model.M_Bullet;

public abstract class MA_Tower {
	
	protected M_Bullet m_bullet = new M_Bullet();
	protected int x_pos,y_pos;
	protected ModelInstance model;
    protected ME_TowerState state = ME_TowerState.IDLE;

	public static List<MA_Tower> getAllTowers() {
		List<MA_Tower> list = new ArrayList<>();
		list.addAll(Arrays.asList(new M_SmallTower(), new M_MediumTower(), new M_BigTower()));
		return list;
	}
	
	public void setPos(int x, int y) {
		if(x<0 || y<0) return;
		x_pos = x;
		y_pos = y;
	}

	public int getX_pos(){
		return x_pos;
	}

	public int getY_pos() {
		return y_pos;
	}

	public abstract int getPrice();
	public abstract int getRange();
	public abstract ModelInstance getModel();

	public void tick(float delta) {
	    //do stuff
    }
}
