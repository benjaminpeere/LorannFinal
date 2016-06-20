package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Demon4 extends Mobile{

	Image Demon4;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Demon4(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iDemon4 = new ImageIcon("Images/monster_4.png");
		Demon4 = iDemon4.getImage();
		
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon4		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Demon4;
	}
	
}
