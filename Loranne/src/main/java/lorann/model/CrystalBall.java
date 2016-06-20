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
public class CrystalBall extends NoCross{
	Image CrystalBall;
	/**
	 * |#####################|
	 * |constructor magicball|
	 * |@param Startx	 	 |
	 * |@param Starty	 	 |
	 * |#####################| 
 */	
	public CrystalBall(int Startx, int Starty ){
		x = Startx;
		y = Starty;
		
		ImageIcon iCrystalBall = new ImageIcon("Images/crystal_ball.png");
		CrystalBall = iCrystalBall.getImage();
	}
	/**
	 * |##################################|
	 * |define an image for the magicball |
	 * |@return Magicball			  	  |
	 * |##################################| 
	 */	
	public Image getImage(){
		return CrystalBall;
	}
}
