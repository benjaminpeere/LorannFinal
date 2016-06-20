package lorann.model;

import java.awt.Rectangle;
/**
* |######################|
* | define the hitbox	 |
* | @return Box 		 |
* |######################|
*/

public class Murs {

int x,y;
	
	public Rectangle getBounds(){
		Rectangle Box = new Rectangle (x,y,32,32);
		return Box;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}


