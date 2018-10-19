package de.codecrunch.inst;

import com.badlogic.gdx.utils.JsonValue;
import com.nilunder.bdx.Instantiator;import com.nilunder.bdx.GameObject;
import de.codecrunch.*;
public class iScene extends Instantiator {

	public GameObject newObject(JsonValue gobj){
		String name = gobj.name;

		if (gobj.get("class").asString().equals("Sacky"))
			return new de.codecrunch.Sacky();

		return super.newObject(gobj);
	}
	
}
