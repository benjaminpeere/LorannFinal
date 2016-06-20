package lorann.model;

import java.awt.Image;


import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Demon1 extends Mobile {

	Image Demon1;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Demon1(int Startx, int Starty){
		x = Startx;
		y = Starty;
		
		ImageIcon iDemon1 = new ImageIcon("Images/monster_1.png");
		Demon1 = iDemon1.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon1		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Demon1;
	}
}
