package lorann.model;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Demon3 extends Mobile{

	Image Demon3;
	public Demon3(int Startx, int Starty){

		x = Startx;
		y = Starty;
		
		ImageIcon iDemon3 = new ImageIcon("Images/monster_3.png");
		Demon3 = iDemon3.getImage();
		
	}

	public Image getImage(){
		return Demon3;
	}
	
}
