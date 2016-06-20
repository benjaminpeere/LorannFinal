package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |Demon is an ennemy of Lorann    			  |
 * |@they are four demons for kill Lorann	  	  |
 * |##############################################| 
 */
public class Monster2 extends Mobile{

	Image Monster2;
	/**
	 * |#################|
	 * |constructor demon|
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Monster2(int Startx, int Starty){
		
		x = Startx;
		y = Starty;
		
		ImageIcon iMonster2 = new ImageIcon("Images/monster_2.png");
		Monster2 = iMonster2.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for demon |
	 * |@return Demon2		  	  |
	 * |##########################| 
	 */
	public Image getImage(){
		return Monster2;
	}
}
