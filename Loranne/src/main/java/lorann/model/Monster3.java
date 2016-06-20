package lorann.model;

import java.awt.Image;


import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Monster3 extends Mobile{

	Image Monster3;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Monster3(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iMonster3 = new ImageIcon("Images/monster_3.png");
		Monster3 = iMonster3.getImage();
		
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon3		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Monster3;
	}
	
}
