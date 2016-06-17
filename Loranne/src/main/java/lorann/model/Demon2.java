package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Demon2 extends Mobile{

	Image Demon2;
	public Demon2(int Startx, int Starty){
		
		x = Startx;
		y = Starty;
		
		ImageIcon iDemon2 = new ImageIcon("Images/monster_2.png");
		Demon2 = iDemon2.getImage();
	}
	
	public Image getImage(){
		return Demon2;
	}
}
