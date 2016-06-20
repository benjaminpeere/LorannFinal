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

public class Bone3 extends Walls{
	
	Image bone3;
	/**
	 * |#################|
	 * |constructor bone |
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */	
	public Bone3(int Startx, int Starty){

		this.x = Startx;
		this.y = Starty;
		
		ImageIcon ibone3Img = new ImageIcon("Images/vertical_bone.png");
		bone3= ibone3Img.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for Bone3 |
	 * |@return Bone1		  	  |
	 * |##########################| 
	 */		
	public Image getImage(){
		return bone3;
	}
}
