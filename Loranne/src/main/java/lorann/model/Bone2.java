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

public class Bone2 extends Walls{
	
	Image bone2;
	/**
	 * |#################|
	 * |constructor bone |
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */	
	public Bone2(int Startx, int Starty){

		this.x = Startx;
		this.y = Starty;
		
		ImageIcon ibone2Img = new ImageIcon("Images/horizontal_bone.png");
		bone2= ibone2Img.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for Bone2 |
	 * |@return Bone1		  	  |
	 * |##########################| 
	*/		
	public Image getImage(){
		return bone2;
	}
}
