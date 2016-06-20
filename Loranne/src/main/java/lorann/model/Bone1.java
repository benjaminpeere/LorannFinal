package lorann.model;
/**
 * |######################################|
 * |this class implement a bone,		  |
 * |he allow to block mobile entity		  |
 * |######################################| 
 * 
 */
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bone1 extends Murs{
	
	Image bone1;
	/**
	 * |#################|
	 * |constructor bone |
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Bone1(int Startx, int Starty){

		this.x = Startx;
		this.y = Starty;
		
		ImageIcon ibone1Img = new ImageIcon("Images/bone.png");
		bone1 = ibone1Img.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for Bone1 |
	 * |@return Bone1		  	  |
	 * |##########################| 
	 */	
	public Image getImage(){
		return bone1;
	}
}
