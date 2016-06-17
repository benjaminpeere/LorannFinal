package lorann.model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bourses extends NonMobile{
	Image Bourses;
	
	public Bourses(int Startx, int Starty){
		x = Startx;
		y = Starty;
		
		ImageIcon iBourses = new ImageIcon("Images/purse.png");
		Bourses = iBourses.getImage();
	}

	public Image getImage(){
		return Bourses;
	}

}
