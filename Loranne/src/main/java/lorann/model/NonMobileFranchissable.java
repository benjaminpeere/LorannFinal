package lorann.model;

import java.awt.Rectangle;

public class NonMobileFranchissable {
	/**
	* |##########################################|
	* | define the hitbox of noMobile entity	 |
	* | @return Box 		 					 |
	* |##########################################|
	*/	
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
