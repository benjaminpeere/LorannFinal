package lorann.model;

import java.awt.Image;


import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Monster1 extends Mobile {

	Image Monster1;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Monster1(int Startx, int Starty){
		x = Startx;
		y = Starty;
		
		ImageIcon iMonster1 = new ImageIcon("Images/monster_1.png");
		Monster1 = iMonster1.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon1		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Monster1;
	}
}
