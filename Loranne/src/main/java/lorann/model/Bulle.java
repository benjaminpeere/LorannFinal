package lorann.model;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * |##############################################|
 * |this class implement a magicball   			  |
 * |she is the objectif,					  	  |
 * |Lorran should pick him to open the door	  	  |
 * |##############################################| 
 */
public class Bulle extends NonMobileFranchissable{
	Image Bulle;
	/**
	 * |#####################|
	 * |constructor magicball|
	 * |@param Startx	 	 |
	 * |@param Starty	 	 |
	 * |#####################| 
 */	
	public Bulle(int Startx, int Starty ){
		x = Startx;
		y = Starty;
		
		ImageIcon iBulle = new ImageIcon("Images/crystal_ball.png");
		Bulle = iBulle.getImage();
	}
	/**
	 * |##################################|
	 * |define an image for the magicball |
	 * |@return Magicball			  	  |
	 * |##################################| 
	 */	
	public Image getImage(){
		return Bulle;
	}
}
