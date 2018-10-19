package de.codecrunch;

import com.nilunder.bdx.*;

//dummy - remove me!
public class Sacky extends GameObject{

    public void main(){
        if (Bdx.keyboard.keyHit("space"))
            applyForce(0, 0, 300);
    }
    
}