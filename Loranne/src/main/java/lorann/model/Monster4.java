package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Monster4 extends Mobile{

	Image Monster4;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Monster4(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iMonster4 = new ImageIcon("Images/monster_4.png");
		Monster4 = iMonster4.getImage();
		
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon4		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Monster4;
	}
	
}
