package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Demon2 extends Mobile{

	Image Demon2;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Demon2(int Startx, int Starty){
		
		x = Startx;
		y = Starty;
		
		ImageIcon iDemon2 = new ImageIcon("Images/monster_2.png");
		Demon2 = iDemon2.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon2		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Demon2;
	}
}
