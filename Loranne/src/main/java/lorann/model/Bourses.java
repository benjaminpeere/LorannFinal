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

public class Bourses extends NonMobileFranchissable{
	Image Bourses;
	/**
	 * |##################|
	 * |constructor Purses|
	 * |@param Startx	  |
	 * |@param Starty	  |
	 * |##################| 
	 */	
	public Bourses(int Startx, int Starty){
		x = Startx;
		y = Starty;
		
		ImageIcon iBourses = new ImageIcon("Images/purse.png");
		Bourses = iBourses.getImage();
	}
	/**
	 * |##########################|
	 * |define an image for Purses|
	 * |@return Purses		  	  |
	 * |##########################| 
 */
	public Image getImage(){
		return Bourses;
	}

}
