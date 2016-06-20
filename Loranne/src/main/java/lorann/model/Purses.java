package lorann.model;
/**
 * |######################################|
 * |this class implement a purse,		  |
 * |this purses can be picked by Lorann	  |
 * |she define the player's score	  	  |
 * |######################################| 
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class Purses extends NoCross{
	Image Purses;
	/**
	 * |##################|
	 * |constructor Purses|
	 * |@param Startx	  |
	 * |@param Starty	  |
	 * |##################| 
	 */	
	public Purses(int Startx, int Starty){
		x = Startx;
		y = Starty;
		
		ImageIcon iPurses = new ImageIcon("Images/purse.png");
		Purses = iPurses.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for Purses|
	 * |@return Purses		  	  |
	 * |##########################| 
 */
	public Image getImage(){
		return Purses;
	}

}
