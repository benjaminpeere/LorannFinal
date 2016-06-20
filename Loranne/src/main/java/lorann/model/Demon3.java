package lorann.model;

import java.awt.Image;


import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Demon3 extends Mobile{

	Image Demon3;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Demon3(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iDemon3 = new ImageIcon("Images/monster_3.png");
		Demon3 = iDemon3.getImage();
		
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon3		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Demon3;
	}
	
}
