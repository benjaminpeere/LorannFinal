package lorann.model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bulle extends NonMobile{
	Image Bulle;
	
	public Bulle(int Startx, int Starty ){
		x = Startx;
		y = Starty;
		
		ImageIcon iBulle = new ImageIcon("Images/crystal_ball.png");
		Bulle = iBulle.getImage();
	}
	
	public Image getImage(){
		return Bulle;
	}
}
